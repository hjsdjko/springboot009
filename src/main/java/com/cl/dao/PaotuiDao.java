package com.cl.dao;

import com.cl.entity.PaotuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaotuiView;


/**
 * 跑腿
 * 
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface PaotuiDao extends BaseMapper<PaotuiEntity> {
	
	List<PaotuiView> selectListView(@Param("ew") Wrapper<PaotuiEntity> wrapper);

	List<PaotuiView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuiEntity> wrapper);
	
	PaotuiView selectView(@Param("ew") Wrapper<PaotuiEntity> wrapper);
	

}
