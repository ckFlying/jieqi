package ckflying.jieqi.core.Controller;

import Config.DataSource;
import Config.JieQiTestDataBase;
import ckflying.jieqi.core.Basic.BaseController;
import ckflying.jieqi.core.Basic.Page;
import ckflying.jieqi.core.Basic.ResultMsg;
import entity.Result;
import entity.TableData;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DbService;

import java.util.List;

/**
 * create by wjwang on ${date}
 */
@RestController
@RequestMapping("test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestCon extends BaseController {
    @Autowired
    private DbService dbService;
    @PostMapping("get")
    @RequiresRoles("admin:find")
    public ResultMsg get(@RequestParam String url,@RequestParam String userName,@RequestParam String pwd,@RequestParam String outDir){
        List<TableData> tableDatas= dbService.getSqlInfo(url,userName,pwd);
        Page<TableData> pages=new Page<>();
        pages.setCurrentPage(1);
        pages.setList(tableDatas);
        pages.setPageSize(10);
        pages.setTotal(1);
        ResultMsg<Page> resultMsg=new ResultMsg<>();
        resultMsg.setCode(200);
        resultMsg.setData(pages);
        resultMsg.setStatus("SUCCESS");
        return resultMsg;
    }
    @GetMapping("generator")
    @RequiresRoles("admin:generator")
    public Result generator(@RequestParam String url, @RequestParam String userName, @RequestParam String pwd, @RequestParam String outDir){

        Result resultMsg=new Result();
        resultMsg.setCode(200);
        resultMsg.setStatus("SUCCESS");
        return resultMsg;
    }
}
