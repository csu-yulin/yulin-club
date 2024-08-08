package csu.yulin.service;

import csu.yulin.entity.SubjectCategoryBO;

import java.util.List;

/**
 * 题目分类领域服务
 *
 * @author lp
 * @create 2024-08-06-9:58
 */
public interface SubjectCategoryDomainService {

    /**
     * 添加题目分类
     */
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询岗位大类
     */
    List<SubjectCategoryBO> queryPrimaryCategory();

    /**
     * 根据岗位大类id查询下面的分类
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);
}
