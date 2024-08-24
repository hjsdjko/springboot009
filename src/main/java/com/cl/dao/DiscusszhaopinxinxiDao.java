package com.cl.dao;

import com.cl.entity.DiscusszhaopinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusszhaopinxinxiView;


/**
 * 招聘信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
public interface DiscusszhaopinxinxiDao extends BaseMapper<DiscusszhaopinxinxiEntity> {
	
	List<DiscusszhaopinxinxiView> selectListView(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);

	List<DiscusszhaopinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
	
	DiscusszhaopinxinxiView selectView(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
	

}
