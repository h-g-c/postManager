package postoffice.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postoffice.demo.entity.Newspaper;
import postoffice.demo.result.ResultMap;
import postoffice.demo.service.NewspaperService;

import java.util.Map;
@RestController
@RequestMapping(value = "/postoffice/newspaper",method = RequestMethod.POST)
@Api(value = "进行报纸的展示以及报纸信息的修改")
public class NewspaperController {

    @Autowired
    NewspaperService newspaperService;

    @PostMapping(value = "/getAll",produces = "application/json")
    @ApiOperation(value = "获取所有报纸的全部信息",notes = "成功返回0,失败返回-1")
    public ResultMap getAll()
    {return newspaperService.getAll();
    }
//    @ApiOperation(value = "通过报纸的id删除报纸的信息",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/deleteNewspaper" ,produces = "application/json")
//    public ResultMap delete(@RequestBody Map<String,Object> map)
//    {if(map.get("newspaperId")==null)
//        return ResultMap.errno(-1,"Cannot get value");
//        return newspaperService.deleteById((Integer) map.get("newspaperId"));
//    }
@ApiOperation(value = "通过报纸的id删除报纸的信息",notes = "成功返回0,失败返回-1")
@PostMapping("/deleteNewspaper")
public ResultMap delete(Integer newspaperId)
{if(newspaperId==null)
    return ResultMap.errno(-1,"Cannot get value");
    return newspaperService.deleteById(newspaperId);
}

//    @ApiOperation(value = "可以通过报纸的代发编号(精确)或者报纸的名字(模糊)或者报纸的分类(精确),对报纸进行查找",notes = "成功返回0,失败返回-1")
//    @PostMapping(value = "/sort" ,produces ="application/json")
//    public ResultMap sort(@RequestBody Map<String,Object> map )
//    { if(map.get("value")==null)
//        return ResultMap.errno(-1,"Cannot get value");
//    return newspaperService.search(map.get("value").toString());
//    }
@ApiOperation(value = "可以通过报纸的代发编号(精确)或者报纸的名字(模糊)或者报纸的分类(精确),对报纸进行查找",notes = "成功返回0,失败返回-1")
@PostMapping("/sort")
public ResultMap sort(String value)
{ if(value==null)
    return ResultMap.errno(-1,"Cannot get value");
    return newspaperService.search(value);
}


    @ApiOperation(value = "通过对报纸的ID,对报纸进行修改",notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/update" ,produces ="application/json")
    public ResultMap update(@RequestBody Newspaper newspaper)
    {
        return newspaperService.update(newspaper);
    }

    @ApiOperation(value = "增加报纸的信息，报纸id自动生成",notes = "成功返回0,失败返回-1")
    @PostMapping(value = "/addNewspaper" ,produces ="application/json")
    public ResultMap insert(@RequestBody Newspaper newspaper)
    {
        return newspaperService.insert(newspaper);
    }

}
