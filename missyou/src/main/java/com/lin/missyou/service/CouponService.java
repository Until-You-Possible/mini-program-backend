package com.lin.missyou.service;


import com.lin.missyou.core.enumeration.CouponStatus;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.exception.Http.ParemeterExcepiton;
import com.lin.missyou.model.Activity;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.model.UserCoupon;
import com.lin.missyou.repository.ActivityRepository;
import com.lin.missyou.repository.CouponRepository;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    // 从repository中查询数据
//    @Autowired
//    private CouponRepository couponRepository;
//
//    @Autowired
//    private ActivityRepository activityRepository;
//
//    @Autowired
//    private UserCouponRepository userCouponRepository;

    private final CouponRepository couponRepository;
    private final ActivityRepository activityRepository;
    private final UserCouponRepository userCouponRepository;

    public CouponService(CouponRepository couponRepository,
                         ActivityRepository activityRepository,
                         UserCouponRepository userCouponRepository) {
        this.couponRepository = couponRepository;
        this.activityRepository = activityRepository;
        this.userCouponRepository = userCouponRepository;
    }


    public List<Coupon> getCategory(long cid) {
        Date now = new Date();
        return couponRepository.findByCategory(cid, now);
    }
    public List<Coupon> getWholeStoreCoupons() {
        Date now = new Date();
        return couponRepository.findByWholeStore(true, now);
    }

    public void collectOneCoupon(Long uid, Long couponId) {
        // 查询一次数据库 检验couponId是否对应一张优惠券
        this.couponRepository.findById(couponId).orElseThrow(() -> new NotFoundException(40003));
        // 如果存在 查看优惠券的时间
        // 领取时间(是否能领取，没到时间不能领取)
        // 领取时间和活动关联
        Activity activity = activityRepository.findByCouponListId(couponId).orElseThrow(() -> new NotFoundException(40001));
        Date now = new Date();
        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if (!isIn) {
            throw  new ParemeterExcepiton(40006);
        }
        // 如果用户领领取过，先查询是否存在
        this.userCouponRepository.findFirstByUserIdAndCouponId(uid,couponId)
                .ifPresent((uc) -> { throw new ParemeterExcepiton(40006);});
        // 可以正常领取的插入数据库
        UserCoupon userCouponNew  =  UserCoupon.builder()
                .couponId(couponId)
                .userId(uid)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        userCouponRepository.save(userCouponNew);

    }

    public List<Coupon> getMyAvailableCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyAvailable(uid, now);
    }

    public List<Coupon> getMyUsedCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyUsed(uid, now);
    }

}
