package jq.server.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import entity.Result;
import entity.ResultEnum;
import jq.server.entities.User;
import jq.server.mapper.UserMapper;
import jq.server.service.UserService;
import jq.server.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ckFlying
 * @since 2018-11-27
 */
@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserMapper userMapper;

    @Override
    public Result register(User user) {
        Result result=new Result();
        if(user.isValid(new Object[]{user.getName(),user.getEmail(),user.getRemark(),user.getPassword()})){
            user.setCode(""+IDUtil.getKey());
            user.setId(IDUtil.getKey());
            user.setStatus("未激活");
            user.setIsok(false);
//            userMapper.insert(user);
            result.setResult(ResultEnum.RESULT_ENUM_10001.code(),ResultEnum.RESULT_ENUM_10001.msg());
        }
        else{
            result.setResult(ResultEnum.RESULT_ENUM_10000.code(),ResultEnum.RESULT_ENUM_10000.msg());
        }
        return result;
    }
}
