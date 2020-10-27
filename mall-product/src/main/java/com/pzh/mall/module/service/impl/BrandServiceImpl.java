package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.BrandDao;
import com.pzh.mall.module.domain.Brand;
import com.pzh.mall.module.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:12
 * @Version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public List<Brand> list() {
        return brandDao.list();
    }

    @Override
    public Brand read(long id) {
        return brandDao.read(id);
    }

    @Override
    public void add(Brand brand) {
        brandDao.add(brand);
    }

    @Override
    public void edit(Brand brand) {
        brandDao.edit(brand);
    }

    @Override
    public void remove(long id) {
        brandDao.remove(id);
    }
}
