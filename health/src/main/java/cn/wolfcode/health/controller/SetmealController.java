package cn.wolfcode.health.controller;

import cn.wolfcode.health.domain.CheckGroup;
import cn.wolfcode.health.domain.Setmeal;
import cn.wolfcode.health.qo.PageQo;
import cn.wolfcode.health.qo.SetmealQo;
import cn.wolfcode.health.service.CheckGroupService;
import cn.wolfcode.health.service.SetmealService;
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
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private CheckGroupService checkGroupService;


    @RequestMapping("/setmeal/list")
    public String list(Model model, @ModelAttribute("qo") SetmealQo qo, String f) {
        //qo存储了分页信息
        //分页查询项信息
        PageInfo<Setmeal> pageResult = setmealService.selectByPage(qo);
        System.out.println(pageResult);
//        List<Setmeal> setmeals = setmealService.selectAll();
        model.addAttribute("pageResult", pageResult);
        model.addAttribute("f",f);
        return "/setmeal/list";
    }


    @GetMapping("/setmeal/input")
    public String input(Model model,Integer setmealId) {
        //        查询到所有检查组信息
        List<CheckGroup> checkGroups = checkGroupService.selectAll();
//        带到页面中显示
        model.addAttribute("checkGroups",checkGroups);
        if (setmealId != null){
            Setmeal setmeal = setmealService.selectById(setmealId);
            model.addAttribute("setmeal",setmeal);
        }
        return "/setmeal/input";
    }

    @PostMapping("/setmeal/saveOrUpdate")
    public String saveOrUpdate(Setmeal setmeal, Integer[] groupIds) {
//        将获取到的信息保存到数据库
        setmealService.save(setmeal, groupIds);
        return "redirect:/setmeal/list";
    }
    @RequestMapping("/setmeal/delete")
    public String delete(Integer setmealId){
        try {
            setmealService.delect(setmealId);
        }
        catch (Exception e){
            return "redirect:/setmeal/list?f=1";
        }

        return "redirect:/setmeal/list";
    }
}
