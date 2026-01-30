package com.easylive.admin.controller;

import com.easylive.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @RequestMapping("/loadDataList")
    public Result loadDataList() {
        return Result.success(null);
    }
}
