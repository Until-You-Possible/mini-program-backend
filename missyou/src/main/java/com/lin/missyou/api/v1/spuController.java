package com.lin.missyou.api.v1;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.model.Spu;
import com.lin.missyou.service.SpuService;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.vo.PagingDozer;
import com.lin.missyou.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;


@RestController
@RequestMapping("/spu")
@Validated
public class spuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable  Long id) {
        Spu spu = spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO getSimplifySpu (@PathVariable Long  id) {
        Spu spu = this.spuService.getSpu(id);
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu, vo);
        return vo;

    }


    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                                @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.ConvertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);

    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(@PathVariable(name = "id") Long id,
                                                           @RequestParam(name = "is_root", defaultValue = "false") Boolean isRoot,
                                                           @RequestParam(name = "start", defaultValue = "0") Integer start,
                                                           @RequestParam(name = "count", defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.ConvertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);

    }

}
