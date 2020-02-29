package postoffice.demo.controller;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postoffice.demo.entity.Customer;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/postoffice/user" ,method = RequestMethod.POST)
@Api(value = "用户管理类")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "注册用户",notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/register",produces ="application/json" )
    public ResultMap register(@RequestBody Customer user)
    {
        return   customerService.addUser(user);
    }

//
//    @ApiOperation(value = "通过userName查询信息",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/getInformation",produces ="application/json" )
//    public ResultMap getInformation(@RequestBody Map<String ,Object> map)
//    {if(map.get("userName")==null)
//        return ResultMap.errno(-1,"Cannot get value");
//    return customerService.getUserInformation((String)map.get("userName"));
//    }


    @ApiOperation(value = "通过userName查询信息",notes = "成功返回0,失败返回-1")
    @PostMapping( "/getInformation" )
    public ResultMap getInformation(String userName)
    {if(userName==null)
        return ResultMap.errno(-1,"Cannot get value");
        return customerService.getUserInformation(userName);
    }

//    @ApiOperation(value = "用于登录验证",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/check" ,produces = "application/json")
//    public ResultMap check(@RequestBody Map<String , Object> map)
//    {if(map.get("userName")==null||map.get("password")==null)
//        return ResultMap.errno(-1,"Cannot get value");
//    return customerService.signIn(map.get("userName").toString(),map.get("password").toString());
//    }

    @ApiOperation(value = "用于登录验证",notes = "成功返回0,失败返回-1")
    @PostMapping("/loginIn")
    public ResultMap check(String userName,String password)
    {if(userName==null||password==null)
        return ResultMap.errno(-1,"Cannot get value");
        return customerService.signIn(userName,password);
    }

//    @ApiOperation(value = "通过userName删除某用户的信息",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/deleteByUserName" ,produces = "application/json")
//    public ResultMap delete(@RequestBody Map<String , Object> map) {
//        if(map.get("userName")==null)
//            return ResultMap.errno(-1,"Cannot get value");
//        return customerService.deleteByUserName(map.get("userName").toString());
//    }
@ApiOperation(value = "通过userName删除某用户的信息",notes = "成功返回0,失败返回-1")
@PostMapping("/deleteByUserName")
public ResultMap delete(String userName) {
    if(userName==null)
        return ResultMap.errno(-1,"Cannot get value");
    return customerService.deleteByUserName(userName);
}


    @ApiOperation(value = "通过userName对用户的信息进行更新",notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/update" ,produces = "application/json")
    public ResultMap update(@RequestBody Customer user) {
        return customerService.update(user);
    }




}
