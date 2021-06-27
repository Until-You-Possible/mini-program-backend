package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
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


}
