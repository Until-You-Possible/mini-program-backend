package com.lin.missyou.service;


import com.lin.missyou.model.Coupon;
import com.lin.missyou.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    // 从repository中查询数据
    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getCategory(long cid) {
        Date now = new Date();
        return couponRepository.findByCategory(cid, now);
    }
}
