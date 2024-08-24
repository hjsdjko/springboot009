package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PaotuirenwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaotuirenwuView;


/**
 * 跑腿任务
 *
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface PaotuirenwuService extends IService<PaotuirenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuirenwuView> selectListView(Wrapper<PaotuirenwuEntity> wrapper);
   	
   	PaotuirenwuView selectView(@Param("ew") Wrapper<PaotuirenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuirenwuEntity> wrapper);
   	

}

