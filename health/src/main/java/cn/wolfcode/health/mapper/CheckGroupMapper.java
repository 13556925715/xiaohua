package cn.wolfcode.health.mapper;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.qo.CheckGroupQo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(CheckGroup record);
    List<CheckGroup> selectByPrimaryKey(CheckGroupQo groupId);
    CheckGroup selectById(Integer itemId);
    List<CheckGroup> selectAll();

    int updateByPrimaryKey(CheckGroup record);

//    保存检查组项
    public void insertGroupItem(@Param("groupId") Integer groupId, @Param("itemId") Integer itemId);//组Id，项id
    public void deleteGroupItem(Integer groupId);


    int select(Integer id);

}