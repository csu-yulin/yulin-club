package csu.yulin.service.impl;

import csu.yulin.basic.entity.SubjectCategory;
import csu.yulin.basic.service.SubjectCategoryService;
import csu.yulin.convert.SubjectCategoryBOConverter;
import csu.yulin.entity.SubjectCategoryBO;
import csu.yulin.service.SubjectCategoryDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE
                .convertBOToEntity(subjectCategoryBO);

        subjectCategoryService.save(subjectCategory);
    }
}
