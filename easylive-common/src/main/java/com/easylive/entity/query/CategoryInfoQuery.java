package com.easylive.entity.query;



/**
 * @Description: 分类信息
 * @Author: false
 * @Date: 2026/02/01 19:48:05
 */
public class CategoryInfoQuery extends BaseQuery {
	/**
 	 * 自增分类ID 查询对象
 	 */
	private Integer categoryId;

	/**
 	 * 分类编码 查询对象
 	 */
	private String categoryCode;

	private String categoryCodeFuzzy;

	/**
 	 * 分类名称 查询对象
 	 */
	private String categoryName;

	private String categoryNameFuzzy;

	/**
 	 * 父级分类ID 查询对象
 	 */
	private Integer pCategoryId;

	/**
 	 * 图标 查询对象
 	 */
	private String icon;

	private String iconFuzzy;

	/**
 	 * 背景图 查询对象
 	 */
	private String background;

	private String backgroundFuzzy;

	/**
 	 * 排序号 查询对象
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

	public void setCategoryCodeFuzzy(String categoryCodeFuzzy) {
		this.categoryCodeFuzzy = categoryCodeFuzzy;
	}

	public String getCategoryCodeFuzzy() {
		return categoryCodeFuzzy;
	}

	public void setCategoryNameFuzzy(String categoryNameFuzzy) {
		this.categoryNameFuzzy = categoryNameFuzzy;
	}

	public String getCategoryNameFuzzy() {
		return categoryNameFuzzy;
	}

	public void setIconFuzzy(String iconFuzzy) {
		this.iconFuzzy = iconFuzzy;
	}

	public String getIconFuzzy() {
		return iconFuzzy;
	}

	public void setBackgroundFuzzy(String backgroundFuzzy) {
		this.backgroundFuzzy = backgroundFuzzy;
	}

	public String getBackgroundFuzzy() {
		return backgroundFuzzy;
	}
}