package com.cl.dao;

import com.cl.entity.DiscussnongchanpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongchanpinxinxiView;


/**
 * 农产品信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
public interface DiscussnongchanpinxinxiDao extends BaseMapper<DiscussnongchanpinxinxiEntity> {
	
	List<DiscussnongchanpinxinxiView> selectListView(@Param("ew") Wrapper<DiscussnongchanpinxinxiEntity> wrapper);

	List<DiscussnongchanpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongchanpinxinxiEntity> wrapper);
	
	DiscussnongchanpinxinxiView selectView(@Param("ew") Wrapper<DiscussnongchanpinxinxiEntity> wrapper);
	

}
