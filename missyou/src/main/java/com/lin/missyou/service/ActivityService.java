package com.lin.missyou.service;


import com.lin.missyou.model.Activity;
import com.lin.missyou.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    // 调用repository 根据名称查询优惠券
    @Autowired
    private ActivityRepository activityRepository;


    public Activity findByName(String name) {
        return activityRepository.findByName(name);
    }

}
