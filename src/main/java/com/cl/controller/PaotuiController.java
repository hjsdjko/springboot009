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

import com.cl.entity.PaotuiEntity;
import com.cl.entity.view.PaotuiView;

import com.cl.service.PaotuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 跑腿
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@RestController
@RequestMapping("/paotui")
public class PaotuiController {
    @Autowired
    private PaotuiService paotuiService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PaotuiEntity u = paotuiService.selectOne(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"paotui",  "跑腿" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PaotuiEntity paotui){
    	//ValidatorUtils.validateEntity(paotui);
    	PaotuiEntity u = paotuiService.selectOne(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", paotui.getPaotuizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		paotui.setId(uId);
        paotuiService.insert(paotui);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        PaotuiEntity u = paotuiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PaotuiEntity u = paotuiService.selectOne(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        paotuiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaotuiEntity paotui,
		HttpServletRequest request){
        EntityWrapper<PaotuiEntity> ew = new EntityWrapper<PaotuiEntity>();

		PageUtils page = paotuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaotuiEntity paotui, 
		HttpServletRequest request){
        EntityWrapper<PaotuiEntity> ew = new EntityWrapper<PaotuiEntity>();

		PageUtils page = paotuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaotuiEntity paotui){
       	EntityWrapper<PaotuiEntity> ew = new EntityWrapper<PaotuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paotui, "paotui")); 
        return R.ok().put("data", paotuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaotuiEntity paotui){
        EntityWrapper< PaotuiEntity> ew = new EntityWrapper< PaotuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paotui, "paotui")); 
		PaotuiView paotuiView =  paotuiService.selectView(ew);
		return R.ok("查询跑腿成功").put("data", paotuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaotuiEntity paotui = paotuiService.selectById(id);
		paotui = paotuiService.selectView(new EntityWrapper<PaotuiEntity>().eq("id", id));
        return R.ok().put("data", paotui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaotuiEntity paotui = paotuiService.selectById(id);
		paotui = paotuiService.selectView(new EntityWrapper<PaotuiEntity>().eq("id", id));
        return R.ok().put("data", paotui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuiEntity paotui, HttpServletRequest request){
        if(paotuiService.selectCount(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", paotui.getPaotuizhanghao()))>0) {
            return R.error("跑腿账号已存在");
        }
    	paotui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotui);
    	PaotuiEntity u = paotuiService.selectOne(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", paotui.getPaotuizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		paotui.setId(new Date().getTime());
        paotuiService.insert(paotui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaotuiEntity paotui, HttpServletRequest request){
        if(paotuiService.selectCount(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", paotui.getPaotuizhanghao()))>0) {
            return R.error("跑腿账号已存在");
        }
    	paotui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotui);
    	PaotuiEntity u = paotuiService.selectOne(new EntityWrapper<PaotuiEntity>().eq("paotuizhanghao", paotui.getPaotuizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		paotui.setId(new Date().getTime());
        paotuiService.insert(paotui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaotuiEntity paotui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paotui);
        paotuiService.updateById(paotui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paotuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}