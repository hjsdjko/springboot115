package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussnongchanpinxinxiDao;
import com.cl.entity.DiscussnongchanpinxinxiEntity;
import com.cl.service.DiscussnongchanpinxinxiService;
import com.cl.entity.view.DiscussnongchanpinxinxiView;

@Service("discussnongchanpinxinxiService")
public class DiscussnongchanpinxinxiServiceImpl extends ServiceImpl<DiscussnongchanpinxinxiDao, DiscussnongchanpinxinxiEntity> implements DiscussnongchanpinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongchanpinxinxiEntity> page = this.selectPage(
                new Query<DiscussnongchanpinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussnongchanpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongchanpinxinxiEntity> wrapper) {
		  Page<DiscussnongchanpinxinxiView> page =new Query<DiscussnongchanpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussnongchanpinxinxiView> selectListView(Wrapper<DiscussnongchanpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongchanpinxinxiView selectView(Wrapper<DiscussnongchanpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
