package jq.server.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import jq.server.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ckFlying
 * @since 2018-11-27
 */

public interface UserMapper extends BaseMapper<User> {
    public User selectByKey(long id);
}
