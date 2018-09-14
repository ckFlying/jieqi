package mapper;

import entity.Interface;
import entity.InterfaceExample;
import java.util.List;

public interface InterfaceMapper {
    List<Interface> selectByExample(InterfaceExample example);
}