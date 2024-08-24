package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WupinfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WupinfenleiView;


/**
 * 物品分类
 *
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
public interface WupinfenleiService extends IService<WupinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupinfenleiView> selectListView(Wrapper<WupinfenleiEntity> wrapper);
   	
   	WupinfenleiView selectView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupinfenleiEntity> wrapper);
   	

}

