package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.NewspaperDao;
import postoffice.demo.dao.OrderDao;
import postoffice.demo.dao.PressDao;
import postoffice.demo.dao.ShoppingCartDao;
import postoffice.demo.entity.Newspaper;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.NewspaperService;
@Service
public class newspaperServiceImpl implements NewspaperService {
    @Autowired
    NewspaperDao newspaperManager;
    @Autowired
    PressDao pressManager;
    @Autowired
    ShoppingCartDao shoppingManager;
    @Autowired
    OrderDao orderManager;

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
        { if(pressManager.selectById(newspaper.getPressId())==null)
            return ResultMap.errno(-1,"pressId not exits");
            if(newspaperManager.insert(newspaper)==1)
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
    if(pressManager.selectById(newspaper.getPressId())==null)
        return ResultMap.errno(-1,"pressId not exits");
    if(newspaperManager.update(newspaper)==1)
    {  shoppingManager.updateByNewspaperId(newspaper);
        return ResultMap.errno(0,"success");
    }
    else return ResultMap.errno(-1,"newspaper does not exist");
}
catch (Exception e){
    System.out.println(e.getMessage());
    return ResultMap.errno(-1,"update error");
}
    }

    @Override
    public ResultMap deleteById(int id) {
        try{
        if(newspaperManager.deleteById(id)==1)
        {shoppingManager.deleteByNewspaperId(id);
            return ResultMap.errno(0,"success"); }
        else return ResultMap.errno(-1,"newspaper does not exist");}
        catch (Exception e)
        {
            return ResultMap.errno(-1,"delete error");
        }
    }
}
