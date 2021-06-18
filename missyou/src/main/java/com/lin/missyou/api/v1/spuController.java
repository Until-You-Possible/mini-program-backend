package com.lin.missyou.api.v1;


import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.model.Spu;
import com.lin.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class spuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable Long id) {
        Spu spu = spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }


    @GetMapping("/latest")
    public List<Spu> getLatestSpuList() {
        return this.spuService.getLatestPagingSpu();
    }

}
