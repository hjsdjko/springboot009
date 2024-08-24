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

import com.cl.entity.WupinfenleiEntity;
import com.cl.entity.view.WupinfenleiView;

import com.cl.service.WupinfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 物品分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@RestController
@RequestMapping("/wupinfenlei")
public class WupinfenleiController {
    @Autowired
    private WupinfenleiService wupinfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WupinfenleiEntity wupinfenlei,
		HttpServletRequest request){
        EntityWrapper<WupinfenleiEntity> ew = new EntityWrapper<WupinfenleiEntity>();

		PageUtils page = wupinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wupinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WupinfenleiEntity wupinfenlei, 
		HttpServletRequest request){
        EntityWrapper<WupinfenleiEntity> ew = new EntityWrapper<WupinfenleiEntity>();

		PageUtils page = wupinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wupinfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WupinfenleiEntity wupinfenlei){
       	EntityWrapper<WupinfenleiEntity> ew = new EntityWrapper<WupinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wupinfenlei, "wupinfenlei")); 
        return R.ok().put("data", wupinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WupinfenleiEntity wupinfenlei){
        EntityWrapper< WupinfenleiEntity> ew = new EntityWrapper< WupinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wupinfenlei, "wupinfenlei")); 
		WupinfenleiView wupinfenleiView =  wupinfenleiService.selectView(ew);
		return R.ok("查询物品分类成功").put("data", wupinfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WupinfenleiEntity wupinfenlei = wupinfenleiService.selectById(id);
		wupinfenlei = wupinfenleiService.selectView(new EntityWrapper<WupinfenleiEntity>().eq("id", id));
        return R.ok().put("data", wupinfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WupinfenleiEntity wupinfenlei = wupinfenleiService.selectById(id);
		wupinfenlei = wupinfenleiService.selectView(new EntityWrapper<WupinfenleiEntity>().eq("id", id));
        return R.ok().put("data", wupinfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WupinfenleiEntity wupinfenlei, HttpServletRequest request){
        if(wupinfenleiService.selectCount(new EntityWrapper<WupinfenleiEntity>().eq("fenlei", wupinfenlei.getFenlei()))>0) {
            return R.error("分类已存在");
        }
    	wupinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wupinfenlei);
        wupinfenleiService.insert(wupinfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WupinfenleiEntity wupinfenlei, HttpServletRequest request){
        if(wupinfenleiService.selectCount(new EntityWrapper<WupinfenleiEntity>().eq("fenlei", wupinfenlei.getFenlei()))>0) {
            return R.error("分类已存在");
        }
    	wupinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wupinfenlei);
        wupinfenleiService.insert(wupinfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WupinfenleiEntity wupinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wupinfenlei);
        wupinfenleiService.updateById(wupinfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wupinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
