package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    //查询所有产品
    public List<Product> findAll() throws Exception;

    //保存产品数据
    void save(Product product) throws Exception;

}
