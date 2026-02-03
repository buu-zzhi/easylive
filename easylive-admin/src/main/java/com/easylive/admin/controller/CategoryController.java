package com.easylive.admin.controller;

import com.easylive.entity.po.CategoryInfo;
import com.easylive.entity.query.CategoryInfoQuery;
import com.easylive.entity.vo.ResponseVO;
import com.easylive.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends ABaseController {
    @Resource
    private CategoryInfoService categoryInfoService;

    @RequestMapping("/loadCategory")
    public ResponseVO loadCategory(CategoryInfoQuery query) {
        query.setOrderBy("sort asc");
        List<CategoryInfo> categoryInfoList = categoryInfoService.findListByParam(query);
        return getSuccessResponseVO(categoryInfoList);
    }

}
