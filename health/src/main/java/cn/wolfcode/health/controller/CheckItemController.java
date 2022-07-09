package cn.wolfcode.health.controller;

import cn.wolfcode.health.domain.CheckItem;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.service.CheckItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CheckItemController {
    @Autowired
    private CheckItemService checkItemService;
    @RequestMapping("/checkItem/list")
    public String list(Model model, PageQo qo,String f){
        //qo存储了分页信息
        //分页查询项信息
        PageInfo<CheckItem> pageResult = checkItemService.selectByPage(qo);
        System.out.println(pageResult);
        //查询检查项信息
//        List<CheckItem> checkItems = checkItemService.selectAll();
        model.addAttribute("pageResult",pageResult);

        model.addAttribute("f",f);
//        跳转页面到检查列表页面
        return "checkItem/list";
    }


    @GetMapping("/checkItem/input")
    public String input(Integer itemId,Model model){
        if (itemId != null){
            CheckItem checkItem = checkItemService.selectById(itemId);
            //数据回显到页面
            model.addAttribute("checkItem",checkItem);
        }
        return  "checkItem/input";
    }
    @PostMapping("checkItem/saveOrUpdate")
    public String saveorUpdate(CheckItem checkItem){
        //获取表单数据
        //将表单数据添加到数据库
        checkItemService.save(checkItem);
        return "redirect:/checkItem/list";
    }

    @GetMapping("/checkItem/delete")
    public String delect(Integer itemId){
        try {
            checkItemService.delete(itemId);
        }
        catch (Exception e){

            return "redirect:/checkItem/list?f=1";
        }
        return "redirect:/checkItem/list";
    }
}
