package com.lin.missyou.api.v1;


import com.lin.missyou.model.Coupon;
import com.lin.missyou.service.CouponService;
import com.lin.missyou.vo.CouponPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@ResponseBody
public class CouponController {

    @Autowired
    private CouponService couponService;

    // 进入详情后查询当前spu对应的优惠券
    // 逻辑关系
    // coupon查询 根据分类来查询
    // 每个spu肯定是所属某一个分类的
    // 所以先查询当前spu所属费分类
    @GetMapping("/by/category/{cid}")
    public List<CouponPureVO> getCouponListByCategory(@PathVariable long cid) {
        List<Coupon> couponList = couponService.getCategory(cid);
        if (couponList.isEmpty()) {
            return Collections.emptyList();
        }
        return CouponPureVO.getList(couponList);
    }
}
