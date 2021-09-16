package com.lin.missyou.repository;

import com.lin.missyou.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findByName(String name);

    // 根据优惠券id查询对应的优惠券
    Optional<Activity> findByCouponListId(Long couponId);

}
