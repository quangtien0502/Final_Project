package com.ra.service.Imp;

import com.ra.model.entity.*;
import com.ra.model.enums.OrderStatus;
import com.ra.repository.OrderDetailRepository;
import com.ra.repository.ShoppingCartRepository;
import com.ra.service.IShoppingCartService;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private CommonService commonService;


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderService orderServiceImp;


    @Override
    public List<ShoppingCart> getAll() {
        User user =userService.findById(commonService.findUserIdInContext().getId());
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart){
        User userExist = userService.findById(commonService.findUserIdInContext().getId());
        Product product = shoppingCart.getProduct();
        ShoppingCart shoppingCartFinal=new ShoppingCart(shoppingCart.getId(),userExist,product,shoppingCart.getQuantity());
        if(shoppingCart.getId()==null && shoppingCartRepository.existsByUserAndProduct(userExist,product)){
            //this is inserted
            throw new RuntimeException("This user already has this product in shopping cart");
        }
        return shoppingCartRepository.save(shoppingCartFinal);
    }

    @Override
    public ShoppingCart findById(Long id){
        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("No Shopping Cart found"));
    }


    @Override
    public void deleteOneProductById(Long shoppingCartId) {
        shoppingCartRepository.deleteById(shoppingCartId);
    }

    @Override
    public void deleteAllProductInShoppingCartOfUser(){
        User user=userService.findById(commonService.findUserIdInContext().getId());
        List<ShoppingCart> shoppingCartList=shoppingCartRepository.findByUser(user);
        shoppingCartRepository.deleteAll(shoppingCartList);
    }


    @Override
    public Orders checkout(Address address) {
        User user=userService.findById(commonService.findUserIdInContext().getId());
        //Todo: Create this list order detail => What to pass in the orders of orderDetailList: calculate order quantity,what's unit price and name?
        List<ShoppingCart> shoppingCartList=shoppingCartRepository.findByUser(user);
        if(shoppingCartList.isEmpty()){
            throw new RuntimeException("There are no product found in your shopping cart");
        }
        double totalPrice=0.00;
        for (ShoppingCart shoppingCart : shoppingCartList) {
            totalPrice = totalPrice + shoppingCart.getQuantity() * shoppingCart.getProduct().getUnitPrice();
        }
        Orders orders=Orders.builder()
                .createdAt(new Date())
                .receiveAddress(address.getFullAddress())
                .receivePhone(address.getPhone())
                .receiveName(user.getFullName())
                .status(OrderStatus.CONFIRM)
                .totalPrice(totalPrice)
                .user(user)
                .build();
        Orders ordersNew=orderServiceImp.save(orders);
        List<OrderDetail> orderDetailList=shoppingCartList.stream().map((item)->OrderDetail.builder()
                .orders(ordersNew)
                .orderQuantity(item.getQuantity())
                .unitPrice(item.getProduct().getUnitPrice())
                .name(item.getProduct().getProductName())
                .product(item.getProduct())
                .build()).toList();
        orderDetailList.stream().map((item)->orderDetailRepository.save(item)).toList();
        for (ShoppingCart shoppingCart :
                shoppingCartList) {
            shoppingCartRepository.deleteById(shoppingCart.getId());
        }
        return orderServiceImp.findById(ordersNew.getId());
    }
}
