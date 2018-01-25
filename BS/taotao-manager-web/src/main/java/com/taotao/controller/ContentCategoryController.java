package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分裂管理Controller
 */
@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(
            @RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> result = contentCategoryService.getContentCategoryList(parentId);
        return result;
    }

    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId, String name){
        TaotaoResult result = contentCategoryService.addContentCategory(parentId, name);
        return result;
    }

    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(Long parentId,String name){
        TaotaoResult result = contentCategoryService.updateContentCategory(parentId, name);
        return result;
    }

    @RequestMapping("/content/category/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id){
        TaotaoResult result = contentCategoryService.deleteContentCategory(id);
        return result;
    }
}
