package cn.gcu.design.btss.interceptors;

import cn.gcu.design.btss.domain.Admin;
import cn.gcu.design.btss.utils.CommonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 23:29
 */
public class InterceptorConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute(CommonUtils.SESSION_ADMIN);
        if (admin == null){
            resp.sendRedirect(req.getContextPath() + "/background/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) throws Exception {

    }
}
