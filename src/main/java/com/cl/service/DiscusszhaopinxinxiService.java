package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusszhaopinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusszhaopinxinxiView;


/**
 * 招聘信息评论表
 *
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
public interface DiscusszhaopinxinxiService extends IService<DiscusszhaopinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhaopinxinxiView> selectListView(Wrapper<DiscusszhaopinxinxiEntity> wrapper);
   	
   	DiscusszhaopinxinxiView selectView(@Param("ew") Wrapper<DiscusszhaopinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhaopinxinxiEntity> wrapper);
   	

}

