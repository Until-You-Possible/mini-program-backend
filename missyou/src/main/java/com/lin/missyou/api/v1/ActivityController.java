package com.lin.missyou.api.v1;


import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.model.Activity;
import com.lin.missyou.service.ActivityService;
import com.lin.missyou.vo.ActivityCouponVO;
import com.lin.missyou.vo.ActivityPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // 根据名称查询对应的优惠券
    @GetMapping("/name/{name}")
    public ActivityPureVO getCouponByName(@PathVariable String name) {
        Activity activity = activityService.findByName(name);
        if (activity == null) {
            throw  new NotFoundException(40001);
        }
        return new ActivityPureVO(activity);
    }
    // 根据spu 查询对应的优惠券
    @GetMapping("/name/{name}/with_coupon")
    public ActivityCouponVO getActivityWithCoupon(@PathVariable String name) {
        Activity activity = activityService.findByName(name);
        if (activity == null) {
            throw  new NotFoundException(40001);
        }
        return new ActivityCouponVO(activity);
    }


}
