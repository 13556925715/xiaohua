package cn.wolfcode.health.service;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.domain.Setmeal;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.qo.SetmealQo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Set;

public interface SetmealService {
    public List<Setmeal> selectAll();
    public PageInfo<Setmeal> selectByPage(SetmealQo qo);
    public void save(Setmeal setmeal, Integer[] setmealIds);
    public void delect(Integer setmealId);
    public Setmeal selectById(Integer setmealById);

}
