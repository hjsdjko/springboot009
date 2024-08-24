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


import com.cl.dao.DiscusszhaopinxinxiDao;
import com.cl.entity.DiscusszhaopinxinxiEntity;
import com.cl.service.DiscusszhaopinxinxiService;
import com.cl.entity.view.DiscusszhaopinxinxiView;

@Service("discusszhaopinxinxiService")
public class DiscusszhaopinxinxiServiceImpl extends ServiceImpl<DiscusszhaopinxinxiDao, DiscusszhaopinxinxiEntity> implements DiscusszhaopinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaopinxinxiEntity> page = this.selectPage(
                new Query<DiscusszhaopinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaopinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		  Page<DiscusszhaopinxinxiView> page =new Query<DiscusszhaopinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusszhaopinxinxiView> selectListView(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaopinxinxiView selectView(Wrapper<DiscusszhaopinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
