package com.easylive.service.impl;


import java.util.List;
import com.easylive.entity.query.SimplePage;
import com.easylive.entity.enums.PageSize;
import com.easylive.mapper.CategoryInfoMapper;
import com.easylive.service.CategoryInfoService;
import com.easylive.entity.vo.PaginationResultVO;
import com.easylive.entity.po.CategoryInfo;
import com.easylive.entity.query.CategoryInfoQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description: 分类信息 业务接口实现
 * @Author: false
 * @Date: 2026/02/01 19:48:05
 */
@Service("CategoryInfoMapper")
public class CategoryInfoServiceImpl implements CategoryInfoService{

	@Resource
	private CategoryInfoMapper<CategoryInfo, CategoryInfoQuery> categoryInfoMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<CategoryInfo> findListByParam(CategoryInfoQuery query) {
		return this.categoryInfoMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(CategoryInfoQuery query) {
		return this.categoryInfoMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<CategoryInfo> findListByPage(CategoryInfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<CategoryInfo> list = this.findListByParam(query);
		PaginationResultVO<CategoryInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(CategoryInfo bean) {
		return this.categoryInfoMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<CategoryInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.categoryInfoMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<CategoryInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.categoryInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 CategoryId 查询
 	 */
	@Override
	public CategoryInfo getCategoryInfoByCategoryId(Integer categoryId) {
		return this.categoryInfoMapper.selectByCategoryId(categoryId);}

	/**
 	 * 根据 CategoryId 更新
 	 */
	@Override
	public Integer updateCategoryInfoByCategoryId(CategoryInfo bean, Integer categoryId) {
		return this.categoryInfoMapper.updateByCategoryId(bean, categoryId);}

	/**
 	 * 根据 CategoryId 删除
 	 */
	@Override
	public Integer deleteCategoryInfoByCategoryId(Integer categoryId) {
		return this.categoryInfoMapper.deleteByCategoryId(categoryId);}

	/**
 	 * 根据 CategoryCode 查询
 	 */
	@Override
	public CategoryInfo getCategoryInfoByCategoryCode(String categoryCode) {
		return this.categoryInfoMapper.selectByCategoryCode(categoryCode);}

	/**
 	 * 根据 CategoryCode 更新
 	 */
	@Override
	public Integer updateCategoryInfoByCategoryCode(CategoryInfo bean, String categoryCode) {
		return this.categoryInfoMapper.updateByCategoryCode(bean, categoryCode);}

	/**
 	 * 根据 CategoryCode 删除
 	 */
	@Override
	public Integer deleteCategoryInfoByCategoryCode(String categoryCode) {
		return this.categoryInfoMapper.deleteByCategoryCode(categoryCode);}
}