package com.lin.missyou.api.v1;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.model.Theme;
import com.lin.missyou.service.ThemeService;
import com.lin.missyou.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;
    // 提供两个接口
    @GetMapping("/by/names")
    public List<ThemePureVO> getThemeGroupByNames(@RequestParam(name = "names") String names) {
        // 前端传参数,分割
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByNames(nameList);
        List<ThemePureVO> list = new ArrayList<>();
        themes.forEach(theme -> {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO vo = mapper.map(theme, ThemePureVO.class);
            list.add(vo);
        });
        return list;
    }

    // with_spu接口
    @GetMapping("/by/{name}/with_spu")
    public Theme getThemeByNameWithSpu(@PathVariable(name = "name") String themeName) {
        Optional<Theme> optionalTheme = themeService.findByName(themeName);
        return optionalTheme.orElseThrow(() -> new NotFoundException(30003));
    }



}
