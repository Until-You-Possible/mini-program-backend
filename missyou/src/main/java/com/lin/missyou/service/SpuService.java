package com.lin.missyou.service;


import com.lin.missyou.model.Spu;
import com.lin.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {

    @Autowired
    SpuRepository spuRepository;

    public Spu getSpu(long id) {
        return  this.spuRepository.findOneById(id);
    }

    public List<Spu> getLatestPagingSpu() {
        return this.spuRepository.findAll();
    }

}
