package cn.wolfcode.health.mapper;

import cn.wolfcode.health.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    Admin selectAll();
    Admin login(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

    int updateByPrimaryKey(Admin record);
}