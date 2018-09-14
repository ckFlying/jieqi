package mapper;

import entity.Project;
import entity.ProjectExample;
import java.util.List;

public interface ProjectMapper {
    List<Project> selectByExample(ProjectExample example);
}