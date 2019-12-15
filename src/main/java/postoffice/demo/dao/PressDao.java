package postoffice.demo.dao;

import postoffice.demo.entity.Press;

import java.util.List;

public interface PressDao {
    List<Press> getAll();
    Press selectById(int id);
    int  updateById(Press press);
    int  insert(Press press);
    int  deleteById(int id);
    Press selectByName(String name);
}
