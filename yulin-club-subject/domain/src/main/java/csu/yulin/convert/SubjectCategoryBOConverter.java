package csu.yulin.convert;

import csu.yulin.basic.entity.SubjectCategory;
import csu.yulin.entity.SubjectCategoryBO;
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
public interface SubjectCategoryBOConverter {

    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);

    /**
     * 将BO转换为实体
     */
    SubjectCategory convertBoToEntity(SubjectCategoryBO subjectCategoryBO);

    /**
     * 将实体列表转换为BO列表
     */
    List<SubjectCategoryBO> convertEntityListToBoList(List<SubjectCategory> subjectCategoryList);
}
