package com.easylive.entity.po;

import java.io.Serializable;


/**
 * @Description: 分类信息
 * @Author: false
 * @Date: 2026/02/01 19:48:05
 */
public class CategoryInfo implements Serializable {
	/**
 	 * 自增分类ID
 	 */
	private Integer categoryId;

	/**
 	 * 分类编码
 	 */
	private String categoryCode;

	/**
 	 * 分类名称
 	 */
	private String categoryName;

	/**
 	 * 父级分类ID
 	 */
	private Integer pCategoryId;

	/**
 	 * 图标
 	 */
	private String icon;

	/**
 	 * 背景图
 	 */
	private String background;

	/**
 	 * 排序号
 	 */
	private Integer sort;


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setPCategoryId(Integer pCategoryId) {
		this.pCategoryId = pCategoryId;
	}

	public Integer getPCategoryId() {
		return pCategoryId;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBackground() {
		return background;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}
	@Override
	public String toString() {
		return "自增分类ID:" + (categoryId == null ? "空" : categoryId) + "," + 
				"分类编码:" + (categoryCode == null ? "空" : categoryCode) + "," + 
				"分类名称:" + (categoryName == null ? "空" : categoryName) + "," + 
				"父级分类ID:" + (pCategoryId == null ? "空" : pCategoryId) + "," + 
				"图标:" + (icon == null ? "空" : icon) + "," + 
				"背景图:" + (background == null ? "空" : background) + "," + 
				"排序号:" + (sort == null ? "空" : sort);
		}
}