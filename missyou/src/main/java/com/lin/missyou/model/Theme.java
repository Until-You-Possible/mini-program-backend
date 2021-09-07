package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Theme extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private String name;
    private Timestamp createTime;
    private String tplName;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "theme_spu", joinColumns = @JoinColumn(name="theme_id")
            , inverseJoinColumns = @JoinColumn(name = "spu_id"))
    private List<Spu> spuList;

}
