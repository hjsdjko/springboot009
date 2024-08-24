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

import com.cl.entity.DiscusszhaopinxinxiEntity;
import com.cl.entity.view.DiscusszhaopinxinxiView;

import com.cl.service.DiscusszhaopinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 招聘信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
@RestController
@RequestMapping("/discusszhaopinxinxi")
public class DiscusszhaopinxinxiController {
    @Autowired
    private DiscusszhaopinxinxiService discusszhaopinxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhaopinxinxiEntity discusszhaopinxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscusszhaopinxinxiEntity> ew = new EntityWrapper<DiscusszhaopinxinxiEntity>();

		PageUtils page = discusszhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaopinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhaopinxinxiEntity discusszhaopinxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhaopinxinxiEntity> ew = new EntityWrapper<DiscusszhaopinxinxiEntity>();

		PageUtils page = discusszhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaopinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhaopinxinxiEntity discusszhaopinxinxi){
       	EntityWrapper<DiscusszhaopinxinxiEntity> ew = new EntityWrapper<DiscusszhaopinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhaopinxinxi, "discusszhaopinxinxi")); 
        return R.ok().put("data", discusszhaopinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhaopinxinxiEntity discusszhaopinxinxi){
        EntityWrapper< DiscusszhaopinxinxiEntity> ew = new EntityWrapper< DiscusszhaopinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhaopinxinxi, "discusszhaopinxinxi")); 
		DiscusszhaopinxinxiView discusszhaopinxinxiView =  discusszhaopinxinxiService.selectView(ew);
		return R.ok("查询招聘信息评论表成功").put("data", discusszhaopinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhaopinxinxiEntity discusszhaopinxinxi = discusszhaopinxinxiService.selectById(id);
		discusszhaopinxinxi = discusszhaopinxinxiService.selectView(new EntityWrapper<DiscusszhaopinxinxiEntity>().eq("id", id));
        return R.ok().put("data", discusszhaopinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhaopinxinxiEntity discusszhaopinxinxi = discusszhaopinxinxiService.selectById(id);
		discusszhaopinxinxi = discusszhaopinxinxiService.selectView(new EntityWrapper<DiscusszhaopinxinxiEntity>().eq("id", id));
        return R.ok().put("data", discusszhaopinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhaopinxinxiEntity discusszhaopinxinxi, HttpServletRequest request){
    	discusszhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaopinxinxi);
        discusszhaopinxinxiService.insert(discusszhaopinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhaopinxinxiEntity discusszhaopinxinxi, HttpServletRequest request){
    	discusszhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaopinxinxi);
        discusszhaopinxinxiService.insert(discusszhaopinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusszhaopinxinxiEntity discusszhaopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhaopinxinxi);
        discusszhaopinxinxiService.updateById(discusszhaopinxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhaopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusszhaopinxinxiEntity discusszhaopinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscusszhaopinxinxiEntity> ew = new EntityWrapper<DiscusszhaopinxinxiEntity>();
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
		PageUtils page = discusszhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaopinxinxi), params), params));
        return R.ok().put("data", page);
    }








}
