package com.ra.service;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import com.ra.model.enums.OrderStatus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {

    List<Orders> getAll();
    Orders save(Orders orders);
    Orders findById(Long id);
    void deleteById(Long id);

    List<Orders> findByProductStatus(OrderStatus status);

    Orders updateStatus(Long orderId, OrderStatus status);

    Orders findBySerialNumber (String serialNumber);

    Orders cancelOrder(Orders orders);

    List<Orders> findByUser(User user);
}
