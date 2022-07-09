package cn.wolfcode.health.mapper;

import cn.wolfcode.health.domain.Setmeal;
import cn.wolfcode.health.qo.SetmealQo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealMapper {
    int deleteByPrimaryKey(Integer setmealId);

    int insert(Setmeal record);

    Setmeal selectByPrimaryKey(Integer setmealId);

    List<Setmeal> selectAll();

    int updateByPrimaryKey(Setmeal record);

    public void insertGroups(@Param("setmealId") Integer setmealId,@Param("groupId") Integer groupId );

    int select(Integer id);

    List<Setmeal> selectById(SetmealQo id);



}