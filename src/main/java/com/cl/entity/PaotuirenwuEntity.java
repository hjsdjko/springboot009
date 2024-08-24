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
 * 跑腿任务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-09 14:58:08
 */
@TableName("paotuirenwu")
public class PaotuirenwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaotuirenwuEntity() {
		
	}
	
	public PaotuirenwuEntity(T t) {
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
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品分类
	 */
					
	private String wupinfenlei;
	
	/**
	 * 任务描述
	 */
					
	private String renwumiaoshu;
	
	/**
	 * 取货地点
	 */
					
	private String quhuodidian;
	
	/**
	 * 送达地点
	 */
					
	private String songdadidian;
	
	/**
	 * 跑腿费
	 */
					
	private Double paotuifei;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 任务编号
	 */
					
	private String renwubianhao;
	
	
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
	 * 设置：任务描述
	 */
	public void setRenwumiaoshu(String renwumiaoshu) {
		this.renwumiaoshu = renwumiaoshu;
	}
	/**
	 * 获取：任务描述
	 */
	public String getRenwumiaoshu() {
		return renwumiaoshu;
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
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
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
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：任务编号
	 */
	public void setRenwubianhao(String renwubianhao) {
		this.renwubianhao = renwubianhao;
	}
	/**
	 * 获取：任务编号
	 */
	public String getRenwubianhao() {
		return renwubianhao;
	}

}
