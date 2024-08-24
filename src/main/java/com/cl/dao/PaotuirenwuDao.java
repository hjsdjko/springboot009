package com.cl.dao;

import com.cl.entity.PaotuirenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaotuirenwuView;


/**
 * 跑腿任务
 * 
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface PaotuirenwuDao extends BaseMapper<PaotuirenwuEntity> {
	
	List<PaotuirenwuView> selectListView(@Param("ew") Wrapper<PaotuirenwuEntity> wrapper);

	List<PaotuirenwuView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuirenwuEntity> wrapper);
	
	PaotuirenwuView selectView(@Param("ew") Wrapper<PaotuirenwuEntity> wrapper);
	

}
