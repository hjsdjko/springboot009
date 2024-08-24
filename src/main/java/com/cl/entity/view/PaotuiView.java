package com.cl.entity.view;

import com.cl.entity.PaotuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 跑腿
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@TableName("paotui")
public class PaotuiView  extends PaotuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PaotuiView(){
	}
 
 	public PaotuiView(PaotuiEntity paotuiEntity){
 	try {
			BeanUtils.copyProperties(this, paotuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
