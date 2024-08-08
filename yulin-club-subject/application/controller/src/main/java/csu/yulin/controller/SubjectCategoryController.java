package csu.yulin.controller;

import com.google.common.base.Preconditions;
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

import java.util.List;

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

    /**
     * 添加题目分类
     */
    @PostMapping("/add")
    public CommonRespResult<SubjectCategoryBO> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        Preconditions.checkArgument(subjectCategoryDTO != null, "参数不能为空");

        SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                .convertDtoToBO(subjectCategoryDTO);
        subjectCategoryDomainService.add(subjectCategoryBO);
        return CommonRespResult.success(subjectCategoryBO);
    }

    /**
     * 查询岗位大类
     */
    @PostMapping("/queryPrimaryCategory")
    public CommonRespResult<List<SubjectCategoryDTO>> queryPrimaryCategory() {
        List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryPrimaryCategory();
        List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                convertBoListToCategoryDtoList(subjectCategoryBOList);
        return CommonRespResult.success(subjectCategoryDTOList);
    }

    /**
     * 根据岗位大类id查询下面的分类
     */
    @PostMapping("/queryCategoryByPrimary")
    public CommonRespResult<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类id不能为空");

        SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                convertDtoToBO(subjectCategoryDTO);
        List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
        List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                convertBoListToCategoryDtoList(subjectCategoryBOList);
        return CommonRespResult.success(subjectCategoryDTOList);
    }
}
