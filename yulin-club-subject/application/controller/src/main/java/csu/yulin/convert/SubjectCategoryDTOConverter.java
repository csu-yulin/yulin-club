package csu.yulin.convert;

import csu.yulin.entity.SubjectCategoryBO;
import csu.yulin.entity.SubjectCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目分类转换器
 *
 * @author lp
 * @create 2024-08-06-10:04
 */
@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    /**
     * 将DTO转换为BO
     */
    SubjectCategoryBO convertDtoToBO(SubjectCategoryDTO subjectCategoryDTO);

    /**
     * 将BO列表转换为DTO列表
     */
    List<SubjectCategoryDTO> convertBoListToCategoryDtoList(List<SubjectCategoryBO> subjectCategoryBOList);
}
