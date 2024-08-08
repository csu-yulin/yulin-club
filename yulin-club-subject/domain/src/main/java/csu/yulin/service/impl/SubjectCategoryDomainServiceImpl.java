package csu.yulin.service.impl;

import csu.yulin.basic.entity.SubjectCategory;
import csu.yulin.basic.service.SubjectCategoryService;
import csu.yulin.convert.SubjectCategoryBOConverter;
import csu.yulin.entity.SubjectCategoryBO;
import csu.yulin.service.SubjectCategoryDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题目分类领域服务实现
 *
 * @author lp
 * @create 2024-08-06-9:59
 */
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    /**
     * 添加题目分类
     */
    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE
                .convertBoToEntity(subjectCategoryBO);

        subjectCategoryService.save(subjectCategory);
    }

    /**
     * 查询岗位大类
     */
    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory() {
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory();
        return SubjectCategoryBOConverter.INSTANCE
                .convertEntityListToBoList(subjectCategoryList);
    }

    /**
     * 根据岗位大类id查询下面的分类
     */
    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE
                .convertBoToEntity(subjectCategoryBO);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        return SubjectCategoryBOConverter.INSTANCE
                .convertEntityListToBoList(subjectCategoryList);
    }
}
