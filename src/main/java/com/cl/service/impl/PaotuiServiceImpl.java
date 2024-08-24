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


import com.cl.dao.PaotuiDao;
import com.cl.entity.PaotuiEntity;
import com.cl.service.PaotuiService;
import com.cl.entity.view.PaotuiView;

@Service("paotuiService")
public class PaotuiServiceImpl extends ServiceImpl<PaotuiDao, PaotuiEntity> implements PaotuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaotuiEntity> page = this.selectPage(
                new Query<PaotuiEntity>(params).getPage(),
                new EntityWrapper<PaotuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaotuiEntity> wrapper) {
		  Page<PaotuiView> page =new Query<PaotuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PaotuiView> selectListView(Wrapper<PaotuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaotuiView selectView(Wrapper<PaotuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
