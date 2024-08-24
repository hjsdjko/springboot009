package com.cl.dao;

import com.cl.entity.JiedanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiedanxinxiView;


/**
 * 接单信息
 * 
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
public interface JiedanxinxiDao extends BaseMapper<JiedanxinxiEntity> {
	
	List<JiedanxinxiView> selectListView(@Param("ew") Wrapper<JiedanxinxiEntity> wrapper);

	List<JiedanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiedanxinxiEntity> wrapper);
	
	JiedanxinxiView selectView(@Param("ew") Wrapper<JiedanxinxiEntity> wrapper);
	

}
