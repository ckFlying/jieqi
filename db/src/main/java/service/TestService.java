package service;

import entity.Face;
import mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by wjwang on ${date}
 */
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    public Face getFace(){
        Face face=testMapper.getFace(6);
        System.out.println("face:"+face.getFaceInfo());
        return face;
    }
}
