package eccrm.base.position.service.impl;


import com.ycrl.core.beans.BeanWrapBuilder;
import com.ycrl.core.beans.BeanWrapCallback;
import com.ycrl.core.pager.PageVo;
import com.ycrl.utils.tree.PathTreeBuilder;
import eccrm.base.position.bo.ClassifyBo;
import eccrm.base.position.dao.ClassifyDao;
import eccrm.base.position.dao.PositionDao;
import eccrm.base.position.domain.Classify;
import eccrm.base.position.service.ClassifyService;
import eccrm.base.position.vo.ClassifyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generated by chenl on 2014-10-13.
 */

@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyDao classifyDao;
    @Resource
    private PositionDao positionDao;

    @Override
    public String save(Classify classify) {
        classify.setPath("/");
        if (classify.getParent() != null && classify.getParent().getId() == null) {
            classify.setParent(null);
        }
        String id = classifyDao.save(classify);
        PathTreeBuilder.buildAfterSave(classifyDao, classify);
        return id;
    }

    @Override
    public void update(Classify classify) {
        PathTreeBuilder.buildBeforeUpdate(classifyDao, classify);
        if (classify.getParent() != null && classify.getParent().getId() == null) {
            classify.setParent(null);
        }
        classifyDao.update(classify);
    }

    @Override
    public PageVo query(ClassifyBo bo) {
        PageVo vo = new PageVo();
        Long total = classifyDao.getTotal(bo);
        vo.setTotal(total);
        if (total == 0) return vo;
        List<Classify> classifys = classifyDao.query(bo);
        vo.setData(BeanWrapBuilder.newInstance().wrapList(classifys, ClassifyVo.class));
        return vo;
    }

    @Override
    public ClassifyVo findById(String id) {
        return wrap(classifyDao.findById(id));
    }

    @Override
    public List<ClassifyVo> tree(ClassifyBo bo) {
        List<Classify> types = classifyDao.query(bo);
        if (types == null || types.isEmpty()) {
            return null;
        }
        Set<String> ids = new HashSet<String>();
        for (Classify c : types) {
            ids.add(c.getId());
        }

        // 查询是上级的所有ID
        final List<String> isParentIds = classifyDao.isParent(ids);
        // 查询具有岗位的所有ID
        final List<String> hasPositionIds = classifyDao.hasPosition(ids);

        return BeanWrapBuilder.newInstance()
                .setCallback(new BeanWrapCallback<Classify, ClassifyVo>() {
                    @Override
                    public void doCallback(Classify classify, ClassifyVo classifyVo) {
                        String id = classify.getId();
                        if (isParentIds.contains(id)) {
                            classifyVo.setIsParent(true);
                        }
                        if (hasPositionIds.contains(id)) {
                            classifyVo.setHasPosition(true);
                        }
                    }
                })
                .wrapList(types, ClassifyVo.class);
    }

    @Override
    public void deleteByIds(String... ids) {
        if (ids == null || ids.length == 0) return;
        for (String id : ids) {
            // 判断该岗位分类下是否已经有岗位了
            boolean hasPosition = positionDao.hasPosition(id);
            Assert.isTrue(!hasPosition, "岗位分类(" + id + ")下已经配置了岗位，不可以删除!");
            classifyDao.deleteById(id);
        }
    }


    public ClassifyVo wrap(Classify classify) {
        if (classify == null) return null;
        ClassifyVo vo = new ClassifyVo();
        BeanUtils.copyProperties(classify, vo);
        Classify classify1 = classify.getParent();
        if (classify1 != null) {
            vo.setParentId(classify1.getId());
            vo.setParentName(classify1.getName());
        }
        return vo;
    }
}