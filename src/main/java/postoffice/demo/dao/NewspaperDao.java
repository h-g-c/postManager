package postoffice.demo.dao;

import postoffice.demo.entity.Newspaper;

import java.util.List;

public interface NewspaperDao {

    List<Newspaper> getAll();
    List<Newspaper> selectByCategoriesOrNameOrPostalId(String value);
    int insert(Newspaper newspaper);
    int  update(Newspaper newspaper);
    int  deleteById(int id);
    Newspaper getById(int id);
  List<Newspaper> getByPressId(int pressId);
}
