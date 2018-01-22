package com.taotao.content.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ContentService {
    EasyUIDataGridResult getContentList(int page,int rows);
    TaotaoResult addContent(TbContent content);
    List<TbContent> getContentByCid(Long cid);
}
