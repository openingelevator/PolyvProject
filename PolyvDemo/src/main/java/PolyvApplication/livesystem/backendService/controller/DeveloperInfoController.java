package PolyvApplication.livesystem.backendService.controller;

import PolyvApplication.livesystem.backendService.entity.DeveloperInfo;
import PolyvApplication.livesystem.backendService.service.Interface.DeveloperInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.polyv.live.v1.config.LiveGlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Slf4j
@Controller
public class DeveloperInfoController {
    @Autowired
    private DeveloperInfoService developerInfoService;

    /**
     * 用于初始化保利威全局配置
     */
    @PostConstruct
    public void init(){
        LambdaQueryWrapper<DeveloperInfo>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(DeveloperInfo::getDevelopername,"zdf");
        DeveloperInfo dev=developerInfoService.getOne(queryWrapper);

        String userId = dev.getUserid();
        String appId = dev.getAppid();
        String appSecret = dev.getAppsecret();
        LiveGlobalConfig.init(appId,userId,appSecret);
        log.info("--初始化完成--");
    }
}
