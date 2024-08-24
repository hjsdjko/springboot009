package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 跑腿
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@TableName("paotui")
public class PaotuiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaotuiEntity() {
		
	}
	
	public PaotuiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 跑腿账号
	 */
					
	private String paotuizhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 跑腿姓名
	 */
					
	private String paotuixingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 跑腿手机
	 */
					
	private String paotuishouji;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：跑腿账号
	 */
	public void setPaotuizhanghao(String paotuizhanghao) {
		this.paotuizhanghao = paotuizhanghao;
	}
	/**
	 * 获取：跑腿账号
	 */
	public String getPaotuizhanghao() {
		return paotuizhanghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：跑腿姓名
	 */
	public void setPaotuixingming(String paotuixingming) {
		this.paotuixingming = paotuixingming;
	}
	/**
	 * 获取：跑腿姓名
	 */
	public String getPaotuixingming() {
		return paotuixingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：跑腿手机
	 */
	public void setPaotuishouji(String paotuishouji) {
		this.paotuishouji = paotuishouji;
	}
	/**
	 * 获取：跑腿手机
	 */
	public String getPaotuishouji() {
		return paotuishouji;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}

}
