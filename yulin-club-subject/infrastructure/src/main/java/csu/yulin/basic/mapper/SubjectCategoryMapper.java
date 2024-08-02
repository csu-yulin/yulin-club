package csu.yulin.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csu.yulin.basic.entity.SubjectCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 针对表【subject_category(题目分类)】的数据库操作Mapper
 *
 * @author lp
 * @create 2024-08-02 12:02:09
 */
@Mapper
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {

}




