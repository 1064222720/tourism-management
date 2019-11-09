package com.ahani.ssm.service.impl;

import com.ahani.ssm.dao.IProductDao;
import com.ahani.ssm.domain.Product;
import com.ahani.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//ioc控制权交给spring

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    //自动按照类型注入
    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> all = iProductDao.findAll();
        return all;

    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }


}
