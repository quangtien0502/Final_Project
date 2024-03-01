package com.ra.service.Imp;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import com.ra.model.enums.OrderStatus;
import com.ra.repository.OrderRepository;
import com.ra.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Orders findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("No orders found By this ID"));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Orders> findByProductStatus(OrderStatus status) {
        return null;
    }

    @Override
    public Orders updateStatus(Long orderId, OrderStatus status) {
        return null;
    }

    @Override
    public Orders findBySerialNumber(String serialNumber) {
        return null;
    }

    @Override
    public Orders cancelOrder(Orders orders) {
        return null;
    }

    @Override
    public List<Orders> findByUser(User user) {
        return null;
    }
}
