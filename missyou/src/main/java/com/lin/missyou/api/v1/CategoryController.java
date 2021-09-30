package com.lin.missyou.api.v1;


import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.model.Category;
import com.lin.missyou.model.GridCategory;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.service.GridCategoryService;
import com.lin.missyou.vo.CategoryAllVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("category")
@RestController
@ResponseBody
public class CategoryController {

    private final CategoryService categoryService;

    private final GridCategoryService gridCategoryService;

    public CategoryController(CategoryService categoryService, GridCategoryService gridCategoryService) {
        this.categoryService = categoryService;
        this.gridCategoryService = gridCategoryService;
    }

    @GetMapping("/all")
    public CategoryAllVO getAll () {
        Map<Integer, List<Category>> categories = categoryService.getALl();
        return new CategoryAllVO(categories);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategory() {
        List<GridCategory> gridCategories = gridCategoryService.getGridListAll();
        if (gridCategories.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategories;
    }

}
