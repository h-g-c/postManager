package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.NewspaperDao;
import postoffice.demo.entity.Newspaper;
import postoffice.demo.result.ResultMap;
import postoffice.demo.service.NewspaperService;
@Service
public class newspaperServiceImpl implements NewspaperService {
    @Autowired
    NewspaperDao newspaperManager;
    @Override
    public ResultMap getAll() {
        return ResultMap.data(newspaperManager.getAll());
    }
    @Override
    public ResultMap search(String value) {
        return ResultMap.data(newspaperManager.selectByCategoriesOrNameOrPostalId(value));
    }

    @Override
    public ResultMap insert(Newspaper newspaper) {
        try
        {if(newspaperManager.insert(newspaper)==1)
            return ResultMap.errno(0,"success");
        else return ResultMap.errno(-1,"error");
        }
        catch (Exception e){
            return ResultMap.errno(-1,"insert error");
        }
    }

    @Override
    public ResultMap update(Newspaper newspaper) {
try{
    if(newspaperManager.update(newspaper)==1)
        return ResultMap.errno(0,"success");
    else return ResultMap.errno(-1,"user does not exist");
}
catch (Exception e){
    return ResultMap.errno(-1,"update error");
}
    }

    @Override
    public ResultMap deleteById(int id) {
        try{
        if(newspaperManager.deleteById(id)==1)
        return ResultMap.errno(0,"success");
        else return ResultMap.errno(-1,"user does not exist");}
        catch (Exception e)
        {
            return ResultMap.errno(-1,"delete error");
        }
    }
}
