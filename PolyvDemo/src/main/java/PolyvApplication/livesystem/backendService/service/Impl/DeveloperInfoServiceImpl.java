package PolyvApplication.livesystem.backendService.service.Impl;

import PolyvApplication.livesystem.backendService.entity.DeveloperInfo;
import PolyvApplication.livesystem.backendService.mapper.DeveloperInfoMapper;
import PolyvApplication.livesystem.backendService.service.Interface.DeveloperInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DeveloperInfoServiceImpl extends ServiceImpl<DeveloperInfoMapper, DeveloperInfo>implements DeveloperInfoService {

}
