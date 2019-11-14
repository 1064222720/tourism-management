package com.ahani.ssm.controller;

import com.ahani.ssm.domain.Product;
import com.ahani.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        iProductService.save(product);
        return "redirect:findAll.do";
    }



    //查询全部产品
    @RequestMapping("/findAll.do")
    /*@RolesAllowed("admin")*/
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps =iProductService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        return  mv;
    }
}
