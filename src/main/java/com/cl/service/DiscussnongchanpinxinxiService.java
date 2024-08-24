package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussnongchanpinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussnongchanpinxinxiView;


/**
 * 农产品信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
public interface DiscussnongchanpinxinxiService extends IService<DiscussnongchanpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussnongchanpinxinxiView> selectListView(Wrapper<DiscussnongchanpinxinxiEntity> wrapper);
   	
   	DiscussnongchanpinxinxiView selectView(@Param("ew") Wrapper<DiscussnongchanpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussnongchanpinxinxiEntity> wrapper);
   	

}

