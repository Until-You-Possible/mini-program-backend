package com.lin.missyou.service;


import com.lin.missyou.model.Banner;
import com.lin.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;
    public Banner getByName(String name) {
        // 查询数据库
        return bannerRepository.findOneByName(name);
    }
}
