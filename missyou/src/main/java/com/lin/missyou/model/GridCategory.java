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
@Table(name = "grid_category", schema = "missyou", catalog = "")
public class GridCategory {
    @Id
    private Long id;
    private String title;
    private String img;
    private String name;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private Integer categoryId;
    private Integer rootCategoryId;


}
