package com.lin.missyou.model;

import com.lin.missyou.util.ListAndJon;
import com.lin.missyou.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Sku {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;


    @Convert(converter = ListAndJon.class)
    private List<Object> specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

}
