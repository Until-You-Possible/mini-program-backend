package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
public class CategoryAllVO {

    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;

    public CategoryAllVO(Map<Integer, List<Category>> map) {
        this.roots = map.get(1).stream().map(CategoryPureVO::new).collect(Collectors.toList());
        this.subs = map.get(2).stream().map(CategoryPureVO::new).collect(Collectors.toList());
    }
}
