package com.cl.dao;

import com.cl.entity.WupinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WupinfenleiView;


/**
 * 物品分类
 * 
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface WupinfenleiDao extends BaseMapper<WupinfenleiEntity> {
	
	List<WupinfenleiView> selectListView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);

	List<WupinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	
	WupinfenleiView selectView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	

}
