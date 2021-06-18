package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "spu_img", schema = "missyou-v2", catalog = "")
@Setter
@Getter
public class SpuImg extends BaseEntity {
    @Id
    private Long id;
    private String img;
    private Long spuId;

}
