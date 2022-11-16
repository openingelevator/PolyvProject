package PolyvApplication.livesystem.backendService.controller;

import PolyvApplication.livesystem.backendService.common.R;
import PolyvApplication.livesystem.backendService.entity.User;
import PolyvApplication.livesystem.backendService.service.Impl.UserServiceImpl;
import PolyvApplication.livesystem.backendService.service.Interface.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<User>login(HttpServletRequest request, @RequestBody User user){
        String password=user.getPassword();
        password= DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<User>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User check_user=userService.getOne(queryWrapper);

        if(check_user==null){
            return R.error("登录失败");
        }
        if(!check_user.getPassword().equals(password)){
            return R.error("登录失败");
        }
        if(check_user.getStatus()==0){
            return R.error("账号已禁用");
        }
        request.getSession().setAttribute("user",user.getId());
        return R.success(check_user);
    }
}
