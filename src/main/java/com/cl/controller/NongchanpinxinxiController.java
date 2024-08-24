package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;

import com.cl.entity.NongchanpinxinxiEntity;
import com.cl.entity.view.NongchanpinxinxiView;

import com.cl.service.NongchanpinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 农产品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 11:38:20
 */
@RestController
@RequestMapping("/nongchanpinxinxi")
public class NongchanpinxinxiController {
    @Autowired
    private NongchanpinxinxiService nongchanpinxinxiService;


    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanpinxinxiEntity nongchanpinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			nongchanpinxinxi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NongchanpinxinxiEntity> ew = new EntityWrapper<NongchanpinxinxiEntity>();

		PageUtils page = nongchanpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanpinxinxiEntity nongchanpinxinxi, 
		HttpServletRequest request){
        EntityWrapper<NongchanpinxinxiEntity> ew = new EntityWrapper<NongchanpinxinxiEntity>();

		PageUtils page = nongchanpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanpinxinxiEntity nongchanpinxinxi){
       	EntityWrapper<NongchanpinxinxiEntity> ew = new EntityWrapper<NongchanpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanpinxinxi, "nongchanpinxinxi")); 
        return R.ok().put("data", nongchanpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanpinxinxiEntity nongchanpinxinxi){
        EntityWrapper< NongchanpinxinxiEntity> ew = new EntityWrapper< NongchanpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanpinxinxi, "nongchanpinxinxi")); 
		NongchanpinxinxiView nongchanpinxinxiView =  nongchanpinxinxiService.selectView(ew);
		return R.ok("查询农产品信息成功").put("data", nongchanpinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanpinxinxiEntity nongchanpinxinxi = nongchanpinxinxiService.selectById(id);
		nongchanpinxinxi.setClicktime(new Date());
		nongchanpinxinxiService.updateById(nongchanpinxinxi);
		nongchanpinxinxi = nongchanpinxinxiService.selectView(new EntityWrapper<NongchanpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanpinxinxiEntity nongchanpinxinxi = nongchanpinxinxiService.selectById(id);
		nongchanpinxinxi.setClicktime(new Date());
		nongchanpinxinxiService.updateById(nongchanpinxinxi);
		nongchanpinxinxi = nongchanpinxinxiService.selectView(new EntityWrapper<NongchanpinxinxiEntity>().eq("id", id));
        return R.ok().put("data", nongchanpinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinxinxiEntity nongchanpinxinxi, HttpServletRequest request){
    	nongchanpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinxinxi);
        nongchanpinxinxiService.insert(nongchanpinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinxinxiEntity nongchanpinxinxi, HttpServletRequest request){
    	nongchanpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanpinxinxi);
        nongchanpinxinxiService.insert(nongchanpinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanpinxinxiEntity nongchanpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanpinxinxi);
        nongchanpinxinxiService.updateById(nongchanpinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,NongchanpinxinxiEntity nongchanpinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<NongchanpinxinxiEntity> ew = new EntityWrapper<NongchanpinxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = nongchanpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinxinxi), params), params));
        return R.ok().put("data", page);
    }

        /**
     * 按用户购买推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,NongchanpinxinxiEntity nongchanpinxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "chanpinfenlei";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "nongchanpinxinxi").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<NongchanpinxinxiEntity> nongchanpinxinxiList = new ArrayList<NongchanpinxinxiEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        nongchanpinxinxiList.addAll(nongchanpinxinxiService.selectList(new EntityWrapper<NongchanpinxinxiEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<NongchanpinxinxiEntity> ew = new EntityWrapper<NongchanpinxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = nongchanpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanpinxinxi), params), params));
        List<NongchanpinxinxiEntity> pageList = (List<NongchanpinxinxiEntity>)page.getList();
        if(nongchanpinxinxiList.size()<limit) {
                int toAddNum = (limit-nongchanpinxinxiList.size())<=pageList.size()?(limit-nongchanpinxinxiList.size()):pageList.size();
                for(NongchanpinxinxiEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(NongchanpinxinxiEntity o2 : nongchanpinxinxiList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        nongchanpinxinxiList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(nongchanpinxinxiList.size()>limit) {
            nongchanpinxinxiList = nongchanpinxinxiList.subList(0, limit);
        }
        page.setList(nongchanpinxinxiList);
        return R.ok().put("data", page);
    }







}
