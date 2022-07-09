package cn.wolfcode.health.service.Impl;

import cn.wolfcode.health.domain.CheckItem;
import cn.wolfcode.health.domain.Setmeal;
import cn.wolfcode.health.mapper.SetmealMapper;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.qo.SetmealQo;
import cn.wolfcode.health.service.SetmealService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealMapper setmealMapper;
    @Override
    public List<Setmeal> selectAll() {
        return setmealMapper.selectAll();
    }

    @Override
    public PageInfo<Setmeal> selectByPage(SetmealQo qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        //查询数巨
        List<Setmeal> setmeals = setmealMapper.selectById(qo);
        return new PageInfo<Setmeal>(setmeals);
    }

    @Override
    public void save(Setmeal setmeal, Integer[] checkgroups) {
        //        将检查组的信息保存到数据库
        if (setmeal.getSetmealId() == null){
            setmealMapper.insert(setmeal);
        }
        else {
            setmealMapper.updateByPrimaryKey(setmeal);
        }

//        关联保存检查
        //遍历checkgroups,获取到每个检查项的Id
        if (checkgroups != null){
            for(Integer checkgroupId : checkgroups){
                setmealMapper.insertGroups(setmeal.getSetmealId(),checkgroupId);
            }
        }
    }

    @Override
    public void delect(Integer setmealId) {
        //根据itenId从checkgroupitem查询,如果查询到了数据
//        说明在checkgroupitem中依赖着要删除的数据，不在删除该数据，并提示无法删除
        int count = setmealMapper.select(setmealId);
        if(count>0){
            //抛出异常
            throw  new RuntimeException("无法删除，因为有其他数据依赖");
        }
        setmealMapper.deleteByPrimaryKey(setmealId);


    }

    @Override
    public Setmeal selectById(Integer setmealId) {
        return setmealMapper.selectByPrimaryKey(setmealId);
    }
}
