package PolyvApplication.livesystem.backendService.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

//Data注解用于生成getter与setter方法
@Data
public class DeveloperInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //开发者姓名用于标识开发者信息
    @TableId(value = "developername",type = IdType.AUTO)
    private String developername;
    //保利威后台获取的用户id
    private String userid;
    //保利威后台提供的应用id
    private String appid;
    //保利威后台提供的应用密钥
    private String appsecret;
}
