package PolyvApplication.livesystem.backendService.service.Impl;

import PolyvApplication.livesystem.backendService.entity.User;
import PolyvApplication.livesystem.backendService.mapper.UserMapper;
import PolyvApplication.livesystem.backendService.service.Interface.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
