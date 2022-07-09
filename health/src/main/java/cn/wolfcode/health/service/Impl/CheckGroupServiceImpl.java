package cn.wolfcode.health.service.Impl;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.mapper.CheckGroupMapper;
import cn.wolfcode.health.qo.CheckGroupQo;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.service.CheckGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupMapper checkGroupMapper;
    @Override
    public List<CheckGroup> selectAll(){
        return checkGroupMapper.selectAll();
    }

    @Override
    public PageInfo<CheckGroup> selectByPage(CheckGroupQo qo) {
        //通过PageHelper实现分页
        //为PageHelper设置分页
        //StartPage(pageNum: 当前页码,pageSize:每页显示数巨量
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        //查询数巨
        List<CheckGroup> checkGroups = checkGroupMapper.selectByPrimaryKey(qo);
        return new PageInfo<CheckGroup>(checkGroups);
    }
    @Override
    public CheckGroup selectById(Integer groupId) {
        return checkGroupMapper.selectById(groupId);
    }

    @Override
    public void save(CheckGroup checkGroup, Integer[] checkItemIds) {
        if(checkGroup.getGroupId() == null){
//添加操作
            checkGroupMapper.insert(checkGroup);
        }
        else{
//修改操作
            checkGroupMapper.updateByPrimaryKey(checkGroup);
            checkGroupMapper.deleteGroupItem(checkGroup.getGroupId());
        }
//        关联保存检查项
        //遍历checkItemIds,获取到每个检查项的Id
        if (checkItemIds != null){
            for(Integer checkItemId : checkItemIds){
            checkGroupMapper.insertGroupItem(checkGroup.getGroupId(),checkItemId);
            }
        }

    }
    @Override
    public void delete(Integer id){
        int count = checkGroupMapper.select(id);
        if(count > 0){
            throw new RuntimeException("无法删除，因为有依赖");
        }
            checkGroupMapper.deleteGroupItem(id);
            checkGroupMapper.deleteByPrimaryKey(id);

        }
    }

