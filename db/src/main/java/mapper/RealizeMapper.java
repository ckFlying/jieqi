package mapper;

import entity.Realize;
import entity.RealizeExample;
import java.util.List;

public interface RealizeMapper {
    List<Realize> selectByExample(RealizeExample example);
}