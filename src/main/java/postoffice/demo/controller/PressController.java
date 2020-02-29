package postoffice.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postoffice.demo.entity.Press;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.PressService;

@RestController
@RequestMapping(value = "/postoffice/press", method = RequestMethod.POST)
@Api(value = "报纸出版社的信息管理")
public class PressController {
    @Autowired
    PressService pressService;

    @ApiOperation(value = "增加出版社信息", notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/insert", produces = "application/json")
    public ResultMap insert(@RequestBody Press press) {
        return pressService.insert(press);
    }

    //    @ApiOperation(value = "通过删除某出版社的全部信息",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/deleteById",produces ="application/json" )
//    public ResultMap delete(@RequestBody Map<String ,Object> map)
//    { if(map.get("pressId")==null)
//            return ResultMap.errno(-1,"Cannot get value");
//        else return pressService.deleteById((Integer)map.get("pressId"));
//    }
    @ApiOperation(value = "通过删除某出版社的全部信息", notes = "成功返回0,失败返回-1")
    @PostMapping("/deleteById")
    public ResultMap delete(Integer pressId) {
        if (pressId == null)
            return ResultMap.errno(-1, "Cannot get value");
        else return pressService.deleteById(pressId);
    }

    @ApiOperation(value = "得修改出版社的信息", notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/update", produces = "application/json")
    public ResultMap update(@RequestBody Press press) {
        return pressService.update(press);
    }

    @ApiOperation(value = "得到所有出版社的信息", notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/getAll", produces = "application/json")
    public ResultMap getAll() {
        return pressService.getAll();
    }

    //    @ApiOperation(value = "得到出版社信息通过id",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/getById",produces = "application/json")
//    public ResultMap getById(@RequestBody Map<String,Object> map)
//    {
//        if(map.get("pressId")==null)
//            return ResultMap.errno(-1,"Cannot get value");
//        return pressService.selectById((Integer) map.get("pressId"));
//    }
    @ApiOperation(value = "得到出版社信息通过id", notes = "成功返回0,失败返回-1")
    @PostMapping("/getById")
    public ResultMap getById(Integer pressId) {
        if (pressId == null)
            return ResultMap.errno(-1, "Cannot get value");
        return pressService.selectById(pressId);
    }
}
