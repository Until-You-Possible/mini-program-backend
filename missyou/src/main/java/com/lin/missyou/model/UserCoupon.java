package com.lin.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_coupon", schema = "missyou", catalog = "")
public class UserCoupon extends BaseEntity {
    @Id
    private Long id;
    private Long userId;
    private Long couponId;
    private Integer status;
    private Long orderId;
    private Date updateTime;
    private Date createTime;
}
