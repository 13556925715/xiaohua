package cn.wolfcode.health.service.Impl;

import cn.wolfcode.health.domain.CheckItem;
import cn.wolfcode.health.mapper.CheckItemMapper;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.service.CheckItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemMapper checkItemMapper;
    @Override
    public List<CheckItem> selectAll(){
        return checkItemMapper.selectAll();
    }

    @Override
    public PageInfo<CheckItem> selectByPage(PageQo qo) {
        //通过PageHelper实现分页
        //为PageHelper设置分页
        //StartPage(pageNum: 当前页码,pageSize:每页显示数巨量
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        //查询数巨
        List<CheckItem> checkItems = checkItemMapper.selectAll();
        return new PageInfo<CheckItem>(checkItems);
    }

    @Override
    public void save(CheckItem checkItem) {
        //区分当前是添加还是修改
        if(checkItem.getItemId() == null){
            checkItemMapper.insert(checkItem);
        }
        else {
            checkItemMapper.updateByPrimaryKey(checkItem);
        }
    }

    @Override
    public CheckItem selectById(Integer itemId) {
        return checkItemMapper.selectByPrimaryKey(itemId);

    }

    @Override
    public void delete(Integer itemId) {
        //根据itenId从checkgroupitem查询,如果查询到了数据
//        说明在checkgroupitem中依赖着要删除的数据，不在删除该数据，并提示无法删除
        int count = checkItemMapper.select(itemId);
        if(count>0){
            //抛出异常
            throw  new RuntimeException("无法删除，因为有其他数据依赖");
        }
        checkItemMapper.deleteByPrimaryKey(itemId);
    }
}
