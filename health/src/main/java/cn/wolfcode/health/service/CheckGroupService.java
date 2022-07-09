package cn.wolfcode.health.service;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.qo.CheckGroupQo;
import cn.wolfcode.health.qo.PageQo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CheckGroupService {
    public List<CheckGroup> selectAll();
    public PageInfo<CheckGroup> selectByPage(CheckGroupQo qo);
    public CheckGroup selectById(Integer groupId);
    public void save(CheckGroup checkGroup,Integer[] checkItemIds);
    public void delete(Integer groupId);




}
