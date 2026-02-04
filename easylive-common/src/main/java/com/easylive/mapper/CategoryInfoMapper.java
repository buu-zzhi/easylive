package com.easylive.mapper;

import com.easylive.entity.po.CategoryInfo;
import com.easylive.entity.query.CategoryInfoQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 分类信息 Mapper
 * @Author: false
 * @Date: 2026/02/01 19:48:05
 */
public interface CategoryInfoMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 CategoryId 查询
 	 */
	T selectByCategoryId(@Param("categoryId")Integer categoryId);

	/**
 	 * 根据 CategoryId 更新
 	 */
	Integer updateByCategoryId(@Param("bean") T t, @Param("categoryId")Integer categoryId); 

	/**
 	 * 根据 CategoryId 删除
 	 */
	Integer deleteByCategoryId(@Param("categoryId")Integer categoryId);

	/**
 	 * 根据 CategoryCode 查询
 	 */
	T selectByCategoryCode(@Param("categoryCode")String categoryCode);

	/**
 	 * 根据 CategoryCode 更新
 	 */
	Integer updateByCategoryCode(@Param("bean") T t, @Param("categoryCode")String categoryCode); 

	/**
 	 * 根据 CategoryCode 删除
 	 */
	Integer deleteByCategoryCode(@Param("categoryCode")String categoryCode);

    @Select("select ifnull(max(sort),0) from category_info where p_category_id=#{pCategoryId}")
    Integer selectMaxSort(@Param("pCategoryId")Integer pCategoryId);

    void deleteByParam(@Param("query") CategoryInfoQuery categoryInfoQuery);

    void updateSortBatch(@Param("categoryInfoList") List<CategoryInfo> categoryInfoList);
}