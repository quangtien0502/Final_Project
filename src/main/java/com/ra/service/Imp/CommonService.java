package com.ra.service.Imp;

import com.ra.model.entity.User;
import com.ra.model.enums.OrderStatus;
import com.ra.sercurity.UserDetail.UserPrincipal;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommonService {
    public User findUserIdInContext(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserPrincipal userPrinciple= (UserPrincipal) authentication.getPrincipal();
        return userPrinciple.getUser();
    }

    public Pageable pagination(String order, Integer page, Integer limit, String sort){
        Pageable pageable;
        if(order.equals("asc")){
            pageable= PageRequest.of(page,limit, Sort.by(sort).ascending());
        }else {
            pageable= PageRequest.of(page,limit,Sort.by(sort).descending());
        }
        return pageable;
    }

    public OrderStatus convertToOrderStatus(String status){
        OrderStatus orderStatusConvert=OrderStatus.valueOf(status);
        if(orderStatusConvert==OrderStatus.CANCEL||orderStatusConvert==OrderStatus.CONFIRM||orderStatusConvert==OrderStatus.DELIVERY||orderStatusConvert==OrderStatus.DENIED || orderStatusConvert==OrderStatus.SUCCESS || orderStatusConvert==OrderStatus.WAITING){
            return orderStatusConvert;
        }else {
            throw new RuntimeException("No Order Status found for given status");
        }
    }

    public boolean isDateTooOld(Date givenDate) {
        // Get the current date
        Date currentDate = new Date();

        // Calculate the difference in milliseconds between the given date and the current date
        long millisecondsDifference = currentDate.getTime() - givenDate.getTime();

        // Convert the milliseconds to days
        long daysDifference = millisecondsDifference / (24 * 60 * 60 * 1000);

        // Check if the difference is greater than 30 days (approximately one month)
        return daysDifference > 30;
    }
}
