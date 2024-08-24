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

import com.cl.entity.PaotuirenwuEntity;
import com.cl.entity.view.PaotuirenwuView;

import com.cl.service.PaotuirenwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 跑腿任务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@RestController
@RequestMapping("/paotuirenwu")
public class PaotuirenwuController {
    @Autowired
    private PaotuirenwuService paotuirenwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaotuirenwuEntity paotuirenwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			paotuirenwu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PaotuirenwuEntity> ew = new EntityWrapper<PaotuirenwuEntity>();

		PageUtils page = paotuirenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuirenwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaotuirenwuEntity paotuirenwu, 
		HttpServletRequest request){
        EntityWrapper<PaotuirenwuEntity> ew = new EntityWrapper<PaotuirenwuEntity>();

		PageUtils page = paotuirenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuirenwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaotuirenwuEntity paotuirenwu){
       	EntityWrapper<PaotuirenwuEntity> ew = new EntityWrapper<PaotuirenwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paotuirenwu, "paotuirenwu")); 
        return R.ok().put("data", paotuirenwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaotuirenwuEntity paotuirenwu){
        EntityWrapper< PaotuirenwuEntity> ew = new EntityWrapper< PaotuirenwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paotuirenwu, "paotuirenwu")); 
		PaotuirenwuView paotuirenwuView =  paotuirenwuService.selectView(ew);
		return R.ok("查询跑腿任务成功").put("data", paotuirenwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaotuirenwuEntity paotuirenwu = paotuirenwuService.selectById(id);
		paotuirenwu = paotuirenwuService.selectView(new EntityWrapper<PaotuirenwuEntity>().eq("id", id));
        return R.ok().put("data", paotuirenwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaotuirenwuEntity paotuirenwu = paotuirenwuService.selectById(id);
		paotuirenwu = paotuirenwuService.selectView(new EntityWrapper<PaotuirenwuEntity>().eq("id", id));
        return R.ok().put("data", paotuirenwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuirenwuEntity paotuirenwu, HttpServletRequest request){
    	paotuirenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotuirenwu);
        paotuirenwuService.insert(paotuirenwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaotuirenwuEntity paotuirenwu, HttpServletRequest request){
    	paotuirenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotuirenwu);
        paotuirenwuService.insert(paotuirenwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaotuirenwuEntity paotuirenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paotuirenwu);
        paotuirenwuService.updateById(paotuirenwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paotuirenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
