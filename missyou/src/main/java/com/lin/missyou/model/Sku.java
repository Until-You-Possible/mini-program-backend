package com.lin.missyou.model;

import com.lin.missyou.util.GenericAndJson;
import com.lin.missyou.util.ListAndJon;
import com.lin.missyou.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

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
    private String specs;


    public List<Spec> getSpecs() {
        if (this.specs == null) {
           return Collections.emptyList();
        }
        return GenericAndJson.jsonToObject(this.specs);
    }

    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }

    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

}
