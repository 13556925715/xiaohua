package cn.wolfcode.health.service;

import cn.wolfcode.health.domain.CheckItem;
import cn.wolfcode.health.qo.PageQo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CheckItemService {
    public List<CheckItem> selectAll();
    public PageInfo<CheckItem> selectByPage(PageQo qo);
    public void save(CheckItem checkItem);
    public CheckItem selectById(Integer itemId);
    public void delete(Integer itemId);
}
