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

import com.cl.entity.JiedanxinxiEntity;
import com.cl.entity.view.JiedanxinxiView;

import com.cl.service.JiedanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 接单信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
@RestController
@RequestMapping("/jiedanxinxi")
public class JiedanxinxiController {
    @Autowired
    private JiedanxinxiService jiedanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiedanxinxiEntity jiedanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("paotui")) {
			jiedanxinxi.setPaotuizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			jiedanxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiedanxinxiEntity> ew = new EntityWrapper<JiedanxinxiEntity>();

		PageUtils page = jiedanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiedanxinxiEntity jiedanxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiedanxinxiEntity> ew = new EntityWrapper<JiedanxinxiEntity>();

		PageUtils page = jiedanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiedanxinxiEntity jiedanxinxi){
       	EntityWrapper<JiedanxinxiEntity> ew = new EntityWrapper<JiedanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiedanxinxi, "jiedanxinxi")); 
        return R.ok().put("data", jiedanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiedanxinxiEntity jiedanxinxi){
        EntityWrapper< JiedanxinxiEntity> ew = new EntityWrapper< JiedanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiedanxinxi, "jiedanxinxi")); 
		JiedanxinxiView jiedanxinxiView =  jiedanxinxiService.selectView(ew);
		return R.ok("查询接单信息成功").put("data", jiedanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiedanxinxiEntity jiedanxinxi = jiedanxinxiService.selectById(id);
		jiedanxinxi = jiedanxinxiService.selectView(new EntityWrapper<JiedanxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiedanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiedanxinxiEntity jiedanxinxi = jiedanxinxiService.selectById(id);
		jiedanxinxi = jiedanxinxiService.selectView(new EntityWrapper<JiedanxinxiEntity>().eq("id", id));
        return R.ok().put("data", jiedanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
    	jiedanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiedanxinxi);
        jiedanxinxiService.insert(jiedanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
    	jiedanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiedanxinxi);
        jiedanxinxiService.insert(jiedanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiedanxinxiEntity jiedanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiedanxinxi);
        jiedanxinxiService.updateById(jiedanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiedanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
