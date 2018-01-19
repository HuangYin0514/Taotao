package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理Service
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
//        根据父节点查询子节点列表
        TbItemCatExample example = new TbItemCatExample();
//        设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
//        设置parentId
        criteria.andParentIdEqualTo(parentId);
//        执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
//        转换成EasyUITreeNode列表
        ArrayList<EasyUITreeNode> resultlist = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
//            如果节点下有子节点“closed”，如果没有子节点“open”
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");
//            添加到节点列表
            resultlist.add(node);
        }
        return resultlist;
    }
}
