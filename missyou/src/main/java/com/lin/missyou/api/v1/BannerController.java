package com.lin.missyou.api.v1;

import com.lin.missyou.core.interceptors.ScopeLevel;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.lin.missyou.model.Banner;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    @ScopeLevel()
    public Banner getByName(@PathVariable String name) {
        Banner banner = bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }

}
