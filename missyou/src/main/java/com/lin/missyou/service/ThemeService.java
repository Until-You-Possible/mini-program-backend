package com.lin.missyou.service;

import com.lin.missyou.model.Theme;
import com.lin.missyou.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ThemeService {
    // service 调用repository
    // repository jpa去查数据库返回结果
    // 引入repository
    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> findByNames (List<String> names) {
        return themeRepository.findByNames(names);
    }

    public Optional<Theme> findByName(String name) {
        return  themeRepository.findByName(name);
    }

}
