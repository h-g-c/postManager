package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.NewspaperDao;
import postoffice.demo.dao.PressDao;
import postoffice.demo.entity.Press;
import postoffice.demo.result.ResultMap;
import postoffice.demo.service.PressService;

@Service
public class pressServiceImpl implements PressService {
    @Autowired
    PressDao pressManager;
    @Autowired
    NewspaperDao newspaperManager;
    @Override
    public ResultMap getAll() {
        return ResultMap.data(pressManager.getAll());
    }

    @Override
    public ResultMap selectById(int id) {
     return ResultMap.data(pressManager.selectById(id));
    }

    @Override
    public ResultMap update(Press press) {
        try{
            if(pressManager.selectByName(press.getName())!=null)
                return ResultMap.errno(-1,"newPress name exist");
            if(pressManager.updateById(press)==1)
                return ResultMap.errno(0,"success");
            else return ResultMap.errno(-1,"press does not exist");
        }catch (Exception e){
            return ResultMap.errno(-1,"update error");
        }
    }

    @Override
    public ResultMap insert(Press press) {
        try{
            if(pressManager.selectByName(press.getName())!=null)
                return ResultMap.errno(-1,"press name exist");
            if(pressManager.insert(press)==1)
                return ResultMap.errno(0,"success");
            else return ResultMap.errno(-1,"press does not exist");
        }catch (Exception e)
        {
            return ResultMap.errno(-1,"insert error");
        }
    }

    @Override
    public ResultMap deleteById(int id) {
        try{
            if(newspaperManager.getByPressId(id)!=null)
                return ResultMap.errno(-1,"error ,press being used");
            if(pressManager.deleteById(id)==1)
                return ResultMap.errno(0,"success");
            else return ResultMap.errno(-1,"press does not exist");

        }catch (Exception e){
            return ResultMap.errno(-1,"delete error");
        }
    }
}
