package xmu.anygo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xmu.anygo.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(Model model, HttpServletResponse httpResponse,
                        @RequestParam String phone, @RequestParam String password, @RequestParam(value = "next", required = false) String next) {
        Map<String, String> map = loginService.login(phone, password);
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket", map.get("ticket"));
            cookie.setPath("/");
            httpResponse.addCookie(cookie);

            if (StringUtils.isNotBlank(next)) {
                return "redirect:" + next;
            }
            return "redirect:/";
        } else {
            model.addAttribute("msg", map.get("msg"));
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(Model model, HttpServletResponse httpResponse,
                           @RequestParam String phone, @RequestParam String password, @RequestParam(value = "next", required = false) String next) {
        Map<String, String> map = loginService.register(phone, password);
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket", map.get("ticket"));
            cookie.setPath("/");
            httpResponse.addCookie(cookie);

            if (StringUtils.isNotBlank(next))
                return "redirect:" + next;
            else
                return "redirect:/";
        } else {
            model.addAttribute("msg", map.get("msg"));
            return "login";
        }
    }
}
