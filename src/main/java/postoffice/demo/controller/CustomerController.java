package postoffice.demo.controller;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postoffice.demo.entity.Customer;
import postoffice.demo.model.LoginRequest;
import postoffice.demo.model.TokenModel;
import postoffice.demo.util.JedisUtil;
import postoffice.demo.util.Response;
import postoffice.demo.util.Responses;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.CustomerService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

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



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response loginResult(@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse){
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        System.out.println(username);
        System.out.println(password);
            // 验证密码信息, 忽略CASE OR case
            if (customerService.signIn(username,password)) {
                Response response = Responses.successResponse();
                HashMap<String, Object> data = new HashMap<>();
                data.put("successMessage", "登录成功!");

                response.setData(data);
                TokenModel tokenModel = new TokenModel(username);
                JedisUtil.setValue(tokenModel.getUserName(), tokenModel.getToken());
                httpServletResponse.setHeader("Authorization", tokenModel.getUserName() + ":" + tokenModel.getToken());
                return response;
            } else {
                Response response = Responses.errorResponse("用户名或者密码错误");
                HashMap<String, Object> data = new HashMap<>();
                data.put("失败", "用户名或者密码错误！");
                response.setData(data);
                return response;
            }

    }




}
