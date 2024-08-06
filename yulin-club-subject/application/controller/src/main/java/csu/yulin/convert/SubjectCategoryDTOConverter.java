package csu.yulin.convert;

import csu.yulin.entity.SubjectCategoryBO;
import csu.yulin.entity.SubjectCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 题目分类转换器
 *
 * @author lp
 * @create 2024-08-06-10:04
 */
@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDtoToBO(SubjectCategoryDTO subjectCategoryDTO);

}
