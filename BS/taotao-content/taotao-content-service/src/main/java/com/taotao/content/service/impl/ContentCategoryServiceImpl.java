package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类管理Service
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
        //根据parentId查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        //设置查询条件
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加结果列表
            resultList.add(node);
        }
        return resultList;
    }

    @Override
    public TaotaoResult addContentCategory(Long parentId, String name) {
        //创建一个pojo
        TbContentCategory contentCategory = new TbContentCategory();
        //补全对象属性
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        //状态。可选值:1(正常),2(删除)
        contentCategory.setStatus(1);
        contentCategory.setIsParent(false);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //插到数据库
        contentCategoryMapper.insert(contentCategory);
        //判断父节点状态
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()){
            //如果父节点为叶子节点应该改为父节点
            parent.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        //返回结果
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult updateContentCategory(Long id, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setId(id);
        contentCategory.setName(name);
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteContentCategory(Long id) {
        //得到要删除的contentCategory的属性
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        //删除contentCategory
        contentCategoryMapper.deleteByPrimaryKey(id);
        //如果父节点只有一个节点，将父节点改成子节点。
        Long parentId = contentCategory.getParentId();
        TbContentCategoryExample example1 = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andParentIdEqualTo(contentCategory.getParentId());
        List<TbContentCategory> contentCategories = contentCategoryMapper.selectByExample(example1);
        if (contentCategories.isEmpty()){
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(contentCategory.getParentId());
            TbContentCategory contentCategory1 = new TbContentCategory();
            contentCategory1.setId(contentCategory.getParentId());
            contentCategory1.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKeySelective(contentCategory1);
        }
        //如果要删除的contentCategory是父节点
        if (contentCategory.getIsParent()){
            //获得所有子节点
            TbContentCategoryExample example = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(id);
            List<TbContentCategory> categoryList = contentCategoryMapper.selectByExample(example);
            if (!categoryList.isEmpty()) {
                //递归删除所有子节点
                for (TbContentCategory tbContentCategory : categoryList) {
                    this.deleteContentCategory(tbContentCategory.getId());
                }
            }
        }
        return TaotaoResult.ok();

    }
}
















