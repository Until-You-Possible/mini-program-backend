package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "category", schema = "missyou", catalog = "")
public class Category {

    @Id
    private Long id;

    private String name;

    private String description;

    private Boolean isRoot;

    private String img;

    private Long parentId;

    private Long index;

    // 和优惠券的关系 多对多

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coupon_category",
    joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id")
    )
    private List<Coupon> couponList;



}
