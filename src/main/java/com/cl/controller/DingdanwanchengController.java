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

import com.cl.entity.DingdanwanchengEntity;
import com.cl.entity.view.DingdanwanchengView;

import com.cl.service.DingdanwanchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单完成
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
@RestController
@RequestMapping("/dingdanwancheng")
public class DingdanwanchengController {
    @Autowired
    private DingdanwanchengService dingdanwanchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanwanchengEntity dingdanwancheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanwancheng.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("paotui")) {
			dingdanwancheng.setPaotuizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanwanchengEntity> ew = new EntityWrapper<DingdanwanchengEntity>();

		PageUtils page = dingdanwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanwancheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanwanchengEntity dingdanwancheng, 
		HttpServletRequest request){
        EntityWrapper<DingdanwanchengEntity> ew = new EntityWrapper<DingdanwanchengEntity>();

		PageUtils page = dingdanwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanwancheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanwanchengEntity dingdanwancheng){
       	EntityWrapper<DingdanwanchengEntity> ew = new EntityWrapper<DingdanwanchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanwancheng, "dingdanwancheng")); 
        return R.ok().put("data", dingdanwanchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanwanchengEntity dingdanwancheng){
        EntityWrapper< DingdanwanchengEntity> ew = new EntityWrapper< DingdanwanchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanwancheng, "dingdanwancheng")); 
		DingdanwanchengView dingdanwanchengView =  dingdanwanchengService.selectView(ew);
		return R.ok("查询订单完成成功").put("data", dingdanwanchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanwanchengEntity dingdanwancheng = dingdanwanchengService.selectById(id);
		dingdanwancheng = dingdanwanchengService.selectView(new EntityWrapper<DingdanwanchengEntity>().eq("id", id));
        return R.ok().put("data", dingdanwancheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanwanchengEntity dingdanwancheng = dingdanwanchengService.selectById(id);
		dingdanwancheng = dingdanwanchengService.selectView(new EntityWrapper<DingdanwanchengEntity>().eq("id", id));
        return R.ok().put("data", dingdanwancheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanwanchengEntity dingdanwancheng, HttpServletRequest request){
    	dingdanwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanwancheng);
        dingdanwanchengService.insert(dingdanwancheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanwanchengEntity dingdanwancheng, HttpServletRequest request){
    	dingdanwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanwancheng);
        dingdanwanchengService.insert(dingdanwancheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanwanchengEntity dingdanwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanwancheng);
        dingdanwanchengService.updateById(dingdanwancheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanwanchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
