package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiedanxinxiDao;
import com.cl.entity.JiedanxinxiEntity;
import com.cl.service.JiedanxinxiService;
import com.cl.entity.view.JiedanxinxiView;

@Service("jiedanxinxiService")
public class JiedanxinxiServiceImpl extends ServiceImpl<JiedanxinxiDao, JiedanxinxiEntity> implements JiedanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiedanxinxiEntity> page = this.selectPage(
                new Query<JiedanxinxiEntity>(params).getPage(),
                new EntityWrapper<JiedanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiedanxinxiEntity> wrapper) {
		  Page<JiedanxinxiView> page =new Query<JiedanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiedanxinxiView> selectListView(Wrapper<JiedanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiedanxinxiView selectView(Wrapper<JiedanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
