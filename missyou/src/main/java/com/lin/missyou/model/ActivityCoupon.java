package com.lin.missyou.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity_coupon", schema = "missyou", catalog = "")
public class ActivityCoupon {
    private Object id;
    private Object couponId;
    private Object activityId;

    @Id
    @Column(name = "id")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "coupon_id")
    public Object getCouponId() {
        return couponId;
    }

    public void setCouponId(Object couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "activity_id")
    public Object getActivityId() {
        return activityId;
    }

    public void setActivityId(Object activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityCoupon that = (ActivityCoupon) o;
        return Objects.equals(id, that.id) && Objects.equals(couponId, that.couponId) && Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, couponId, activityId);
    }
}
