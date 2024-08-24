package com.cl.dao;

import com.cl.entity.ChanpinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChanpinfenleiView;


/**
 * 产品分类
 * 
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
public interface ChanpinfenleiDao extends BaseMapper<ChanpinfenleiEntity> {
	
	List<ChanpinfenleiView> selectListView(@Param("ew") Wrapper<ChanpinfenleiEntity> wrapper);

	List<ChanpinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ChanpinfenleiEntity> wrapper);
	
	ChanpinfenleiView selectView(@Param("ew") Wrapper<ChanpinfenleiEntity> wrapper);
	

}
