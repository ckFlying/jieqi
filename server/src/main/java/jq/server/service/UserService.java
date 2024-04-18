package jq.server.service;

import com.baomidou.mybatisplus.service.IService;

import entity.Result;
import jq.server.entities.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ckFlying
 * @since 2018-11-27
 */
public interface UserService {
    Result register(User user);
}
