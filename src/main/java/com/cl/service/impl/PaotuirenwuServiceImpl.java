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


import com.cl.dao.PaotuirenwuDao;
import com.cl.entity.PaotuirenwuEntity;
import com.cl.service.PaotuirenwuService;
import com.cl.entity.view.PaotuirenwuView;

@Service("paotuirenwuService")
public class PaotuirenwuServiceImpl extends ServiceImpl<PaotuirenwuDao, PaotuirenwuEntity> implements PaotuirenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaotuirenwuEntity> page = this.selectPage(
                new Query<PaotuirenwuEntity>(params).getPage(),
                new EntityWrapper<PaotuirenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaotuirenwuEntity> wrapper) {
		  Page<PaotuirenwuView> page =new Query<PaotuirenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PaotuirenwuView> selectListView(Wrapper<PaotuirenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaotuirenwuView selectView(Wrapper<PaotuirenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
