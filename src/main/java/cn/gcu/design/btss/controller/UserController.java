package cn.gcu.design.btss.controller;

import cn.gcu.design.btss.domain.User;
import cn.gcu.design.btss.service.UserService;
import cn.gcu.design.btss.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/21 11:14
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    @ResponseBody
    public Object list(@RequestParam(value = "pageNo",required = false,defaultValue = "1")String pageNo,
                             @RequestParam(value = "keyWord",required = false)String keyWord,
                             ModelAndView modelAndView){
        int pageNum = Integer.valueOf(pageNo);
        Page<User> page = userService.findAll(pageNum, CommonUtils.DEFAULT_PAGE_SIZE);
        return page.getContent();
    }

    @PostMapping("/users")
    @ResponseBody
    public Object addition(User user){
        User save = userService.save(user);
        return user;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public Object getUser(@PathVariable("id")String id){
        User user = userService.findOne(id);
        return user;
    }

    @PatchMapping("/users/{id}")
    public String modification(User user){
        return "redirect:/users/{" + user.getId() + "}";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id")String id){

        return "redirect:/users";
    }
}
