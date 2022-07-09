package cn.wolfcode.health.mapper;

import cn.wolfcode.health.domain.CheckItem;
import java.util.List;

public interface CheckItemMapper {
    //根据主键id删除
    int deleteByPrimaryKey(Integer itemId);
//    添加
    int insert(CheckItem record);
//根据id查询
    CheckItem selectByPrimaryKey(Integer itemId);
//查询所有
    List<CheckItem> selectAll();
//修改
    int updateByPrimaryKey(CheckItem record);

    //根据ItemId查询checkgroupitem中是否有依赖数据
    int select(Integer itemId);

}