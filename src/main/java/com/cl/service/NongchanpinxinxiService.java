package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NongchanpinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NongchanpinxinxiView;


/**
 * 农产品信息
 *
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
public interface NongchanpinxinxiService extends IService<NongchanpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanpinxinxiView> selectListView(Wrapper<NongchanpinxinxiEntity> wrapper);
   	
   	NongchanpinxinxiView selectView(@Param("ew") Wrapper<NongchanpinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanpinxinxiEntity> wrapper);
   	

}

