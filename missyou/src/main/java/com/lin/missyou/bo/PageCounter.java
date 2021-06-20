package com.lin.missyou.bo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageCounter {

    public Integer page;
    public Integer count;

}
