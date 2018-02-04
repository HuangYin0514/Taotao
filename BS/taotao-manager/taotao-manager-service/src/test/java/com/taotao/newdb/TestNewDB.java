package com.taotao.newdb;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import javafx.scene.control.TableColumnBase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestNewDB {

    @Test
    public void testnewDb(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        //536563
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo((long) 536563);
        List<TbItem> list = itemMapper.selectByExample(example);
        for (TbItem tbItem : list) {
            System.out.println(tbItem);
        }


    }
}
