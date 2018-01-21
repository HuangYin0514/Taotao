package com.taotao.content;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateContentCategory {

/**
 *  测试更新ContentCategory
 *
    @Test
    public void TestUpdateContentCategory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        ContentCategoryService contentCategoryService = (ContentCategoryService) applicationContext.getBean("contentCategoryServiceImpl");
        TaotaoResult result = contentCategoryService.updateContentCategory((long) 100, "test");
        System.out.println(result);
    }
 */
    @Test
    public void TestdeleteContentCategory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        ContentCategoryService contentCategoryService = (ContentCategoryService) applicationContext.getBean("contentCategoryServiceImpl");
        TaotaoResult result = contentCategoryService.deleteContentCategory((long) 98);
        System.out.println(result);
    }
}
