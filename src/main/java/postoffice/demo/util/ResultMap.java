package postoffice.demo.util;

import java.util.HashMap;

public class ResultMap extends HashMap {
   public static ResultMap errno(int id, String message)
    {
        ResultMap result=new ResultMap();
        result.put("errno",id);
        result.put("message",message);
        return  result;
    }
    public static ResultMap data(Object data)
    {

        ResultMap result=new ResultMap();
        result.put("errno",0);
        result.put("data",data);
        return  result;
    }
    public static ResultMap errno(int id)
    {
        if(id==1)
            return ResultMap.errno(0,"success");
        else return ResultMap.errno(-1,"error");
    }
}
