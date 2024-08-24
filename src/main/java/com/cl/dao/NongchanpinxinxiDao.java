package com.cl.dao;

import com.cl.entity.NongchanpinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinxinxiView;


/**
 * 农产品信息
 * 
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
public interface NongchanpinxinxiDao extends BaseMapper<NongchanpinxinxiEntity> {
	
	List<NongchanpinxinxiView> selectListView(@Param("ew") Wrapper<NongchanpinxinxiEntity> wrapper);

	List<NongchanpinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanpinxinxiEntity> wrapper);
	
	NongchanpinxinxiView selectView(@Param("ew") Wrapper<NongchanpinxinxiEntity> wrapper);
	

}
