package csu.yulin.basic.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import csu.yulin.basic.entity.SubjectCategory;
import csu.yulin.basic.mapper.SubjectCategoryMapper;
import csu.yulin.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 针对表【subject_category(题目分类)】的数据库操作Service实现
 *
 * @author lp
 * @create 2024-08-02 12:02:09
 */
@Service
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory>
        implements SubjectCategoryService {

    /**
     * 查询岗位大类
     */
    @Override
    public List<SubjectCategory> queryPrimaryCategory() {
        return this.list(Wrappers.lambdaQuery(SubjectCategory.class)
                .eq(SubjectCategory::getParentId, 0L));
    }

    /**
     * 根据岗位大类id查询下面的分类
     */
    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return this.list(Wrappers.lambdaQuery(SubjectCategory.class)
                .eq(SubjectCategory::getParentId, subjectCategory.getParentId()));
    }
}




