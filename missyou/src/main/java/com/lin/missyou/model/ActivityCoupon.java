package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "activity_coupon", schema = "missyou", catalog = "")
public class ActivityCoupon extends BaseEntity {
    @Id
    private Long id;
    private Long couponId;
    private Long activityId;
}
