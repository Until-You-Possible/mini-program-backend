package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "user_coupon", schema = "missyou", catalog = "")
public class UserCoupon extends BaseEntity {
    @Id
    private Long id;
    private String userId;
    private String couponId;
    private Boolean status;
    private Long orderId;
    private Date updateTime;
}
