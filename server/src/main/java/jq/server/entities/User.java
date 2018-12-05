package jq.server.entities;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * create by wjwang on 2018/11/28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标示
     */
    private Long id;
    private String password;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态 1启用 0 停用
     */
    private String status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    private Boolean isok;
    private String email;
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public boolean isValid(Object[] os) {
        for(Object obj:os) {
            if (obj == null) {
                return false;
            } else if (obj instanceof String) {
                return null != StringUtils.trimToNull((String) obj);
            } else {
                return !(obj instanceof Collection && ((Collection)obj).size() == 0);
            }
        }
        return false;
    }
}
