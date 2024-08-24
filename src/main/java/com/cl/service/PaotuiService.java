package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PaotuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaotuiView;


/**
 * 跑腿
 *
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface PaotuiService extends IService<PaotuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuiView> selectListView(Wrapper<PaotuiEntity> wrapper);
   	
   	PaotuiView selectView(@Param("ew") Wrapper<PaotuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuiEntity> wrapper);
   	

}

