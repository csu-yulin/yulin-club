package csu.yulin;

import csu.yulin.basic.entity.SubjectCategory;
import csu.yulin.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 刷题微服务控制器
 *
 * @author lp
 * @create 2024-08-02-9:58
 */
@RestController
public class SubjectController {
    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/hello")
    public String hello() {
        SubjectCategory subjectCategory = subjectCategoryService.getById(1);
        return subjectCategory.getCategoryName();
    }
}
