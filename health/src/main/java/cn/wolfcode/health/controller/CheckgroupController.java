package cn.wolfcode.health.controller;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.domain.CheckItem;
import cn.wolfcode.health.qo.CheckGroupQo;
import cn.wolfcode.health.service.CheckGroupService;
import cn.wolfcode.health.service.CheckItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CheckgroupController {
    @Autowired
    private CheckGroupService checkGroupService;
    @Autowired
    private CheckItemService checkItemService;
    @RequestMapping("/checkGroup/list")
    public String list(Model model, @ModelAttribute("qo") CheckGroupQo qo,String f) {
        //条件查询检查组信息
        PageInfo<CheckGroup> pageResult = checkGroupService.selectByPage(qo);
        //qo存储了分页信息
        //分页查询项信息
        System.out.println(pageResult);
        //查询检查项信息
//        List<CheckGroup> checkGroups = checkGroupService.selectAll();
        model.addAttribute("pageResult",pageResult);
        model.addAttribute("f",f);
//        跳转页面到检查列表页面
        return "/checkgroup/list";
    }

    @GetMapping ("/checkGroup/input")
    public String input(Model model,Integer groupId) {
//        查询到所有检查项信息
        List<CheckItem> checkItems = checkItemService.selectAll();
//        带到页面中显示
        model.addAttribute("checkItems",checkItems);
//根据groupId查询对应的检查组信息，回显数据
        if ( groupId != null){
            CheckGroup checkGroup = checkGroupService.selectById(groupId);
            //数据回显到页面
            model.addAttribute("checkGroup",checkGroup);
        }
        return "checkgroup/input";
    }
    @PostMapping("/checkGroup/saveOrUpdate")
    public String saveOrUpdate(CheckGroup checkGroup,Integer[] checkItemIds){
//        将获取到的信息保存到数据库
        checkGroupService.save(checkGroup,checkItemIds);

        return "redirect:/checkGroup/list";
    };
    @RequestMapping("/checkGroup/delete")
    public String delete(Integer groupId){
        try {
            checkGroupService.delete(groupId);
        }
        catch (Exception e){
            return "redirect:/checkGroup/list?f=1";
        }

        return "redirect:/checkGroup/list";
    }








}
