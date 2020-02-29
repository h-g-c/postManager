package postoffice.demo.service;

import postoffice.demo.entity.Press;
import postoffice.demo.util.ResultMap;

public interface PressService {
    ResultMap getAll();
    ResultMap selectById(int id);
    ResultMap update(Press press);
    ResultMap insert(Press press);
    ResultMap deleteById(int id);
 }
