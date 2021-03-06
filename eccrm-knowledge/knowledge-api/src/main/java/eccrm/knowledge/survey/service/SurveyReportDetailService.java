package eccrm.knowledge.survey.service;

import com.ycrl.core.pager.PageVo;
import eccrm.knowledge.survey.bo.SurveyReportDetailBo;
import eccrm.knowledge.survey.domain.SurveyReportDetail;
import eccrm.knowledge.survey.vo.SurveyReportDetailVo;

/**
 * @author Michael
 */
public interface SurveyReportDetailService {

    /**
     * 保存
     */
    String save(SurveyReportDetail surveyReportDetail);

    /**
     * 更新
     */
    void update(SurveyReportDetail surveyReportDetail);

    /**
     * 分页查询
     */
    PageVo pageQuery(SurveyReportDetailBo bo);

    /**
     * 根据ID查询对象的信息
     */
    SurveyReportDetailVo findById(String id);

    /**
     * 批量删除
     */
    void deleteByIds(String[] ids);

    /**
     * 答题
     *
     * @param id     题目编号
     * @param answer 答案
     * @return 是否正确
     */
    boolean answer(String id, String answer);

    /**
     * 批量答题
     *
     * @param details
     */
    SurveyResult answer(SurveyReportDetail[] details);

    /**
     * 查询某套试卷、某一套题具体人(由试卷决定）的答题情况
     *
     * @param surveyReportId 注册人试卷ID
     * @param subjectId      题目ID
     * @return 答案
     */
    String getAnswer(String surveyReportId, String subjectId);
}
