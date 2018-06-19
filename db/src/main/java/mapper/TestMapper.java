package mapper;

import entity.Face;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * create by wjwang on ${date}
 */
@Repository
public interface  TestMapper {
    @Select("SELECT * FROM face WHERE face_id = #{id}")
    @Results(value = { @Result(id = true, column = "face_id", property = "faceId"), @Result(column = "face_info", property = "faceInfo") })
    public Face getFace(@Param("id") int id);
}
