package cn.gcu.design.btss.controller;

import cn.gcu.design.btss.domain.Admin;
import cn.gcu.design.btss.domain.Module;
import cn.gcu.design.btss.enums.BtssServiceEnum;
import cn.gcu.design.btss.exceptions.AdminServiceException;
import cn.gcu.design.btss.service.AdminService;
import cn.gcu.design.btss.service.ModuleService;
import cn.gcu.design.btss.utils.CommonUtils;
import cn.gcu.design.btss.utils.ValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 21:13
 */
@Controller
@RequestMapping("/background")
public class CommonController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ModuleService moduleService;
    @GetMapping("/home")
    public String home(){
        return "common/login";
    }

    /**
     * 获取验证码图片接口
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/verification")
    public void verification(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCodeUtil code = new ValidateCodeUtil(80,30,4,100);
        session.setAttribute("code", code.getCode());
        code.write(response.getOutputStream());
    }

    /**
     * 管理员登录接口
     * @param admin
     * @param code
     * @param session
     * @param modelAndView
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid Admin admin, BindingResult bindingResult,
                              @RequestParam("code")String code,
                              HttpSession session,
                              ModelAndView modelAndView)throws AdminServiceException {
        //表单校验
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("common/login");
            return modelAndView;
        }
        String sessionCode = (String) session.getAttribute("code");
        try {
            //验证码、用户名密码校验
            Admin checkAdmin = adminService.loginCheck(admin.getUname(),admin.getPassword(),code,sessionCode);
            //找出管理员模块
            List<Module> modules = moduleService.findByLevel(checkAdmin.getLevel());
            session.setAttribute(CommonUtils.SESSION_ADMIN,checkAdmin);
            modelAndView.addObject("modules",modules);
            modelAndView.setViewName("common/main");
        }catch (AdminServiceException e){
            modelAndView.addObject(CommonUtils.ERROR_MSG,e.getMessage());
            modelAndView.setViewName("common/login");
        }catch (Exception e){
            modelAndView.addObject(CommonUtils.ERROR_MSG, BtssServiceEnum.UNKNOW_ERROR.getMsg());
            modelAndView.setViewName("common/login");
        }
        return modelAndView;
    }
}
