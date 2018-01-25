package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult contentList(Integer page, Integer rows){
        EasyUIDataGridResult result = contentService.getContentList(page, rows);
        return result;
    }

    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content){
        TaotaoResult result = contentService.addContent(content);
        return result;
    }
}
