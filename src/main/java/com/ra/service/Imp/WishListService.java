package com.ra.service.Imp;

import com.ra.model.entity.User;
import com.ra.model.entity.WishList;
import com.ra.repository.WishListRepository;
import com.ra.service.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService implements IWishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private CommonService commonService;

    @Override
    public List<WishList> getAll() {
        User user=commonService.findUserIdInContext();
        return wishListRepository.getAllByUser(user);

    }

    @Override
    public WishList save(WishList wishList) {
        return null;
    }

    @Override
    public WishList findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
