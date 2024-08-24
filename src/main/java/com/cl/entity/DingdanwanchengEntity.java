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
 * 订单完成
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-09 14:58:09
 */
@TableName("dingdanwancheng")
public class DingdanwanchengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DingdanwanchengEntity() {
		
	}
	
	public DingdanwanchengEntity(T t) {
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
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 跑腿账号
	 */
					
	private String paotuizhanghao;
	
	/**
	 * 跑腿姓名
	 */
					
	private String paotuixingming;
	
	/**
	 * 跑腿手机
	 */
					
	private String paotuishouji;
	
	/**
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品分类
	 */
					
	private String wupinfenlei;
	
	/**
	 * 跑腿费
	 */
					
	private Double paotuifei;
	
	/**
	 * 取货地点
	 */
					
	private String quhuodidian;
	
	/**
	 * 送达地点
	 */
					
	private String songdadidian;
	
	/**
	 * 完成时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date wanchengshijian;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
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
	 * 设置：物品名称
	 */
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
	/**
	 * 设置：物品分类
	 */
	public void setWupinfenlei(String wupinfenlei) {
		this.wupinfenlei = wupinfenlei;
	}
	/**
	 * 获取：物品分类
	 */
	public String getWupinfenlei() {
		return wupinfenlei;
	}
	/**
	 * 设置：跑腿费
	 */
	public void setPaotuifei(Double paotuifei) {
		this.paotuifei = paotuifei;
	}
	/**
	 * 获取：跑腿费
	 */
	public Double getPaotuifei() {
		return paotuifei;
	}
	/**
	 * 设置：取货地点
	 */
	public void setQuhuodidian(String quhuodidian) {
		this.quhuodidian = quhuodidian;
	}
	/**
	 * 获取：取货地点
	 */
	public String getQuhuodidian() {
		return quhuodidian;
	}
	/**
	 * 设置：送达地点
	 */
	public void setSongdadidian(String songdadidian) {
		this.songdadidian = songdadidian;
	}
	/**
	 * 获取：送达地点
	 */
	public String getSongdadidian() {
		return songdadidian;
	}
	/**
	 * 设置：完成时间
	 */
	public void setWanchengshijian(Date wanchengshijian) {
		this.wanchengshijian = wanchengshijian;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getWanchengshijian() {
		return wanchengshijian;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
