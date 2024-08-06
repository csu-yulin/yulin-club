package csu.yulin.controller;

import csu.yulin.convert.SubjectCategoryDTOConverter;
import csu.yulin.entity.CommonRespResult;
import csu.yulin.entity.SubjectCategoryBO;
import csu.yulin.entity.SubjectCategoryDTO;
import csu.yulin.service.SubjectCategoryDomainService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题目分类控制器
 *
 * @author lp
 * @create 2024-08-06-10:12
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public CommonRespResult<SubjectCategoryBO> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {


        SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToBO(subjectCategoryDTO);
        subjectCategoryDomainService.add(subjectCategoryBO);
        return CommonRespResult.success(subjectCategoryBO);
    }
}
