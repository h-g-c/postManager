package postoffice.demo.service;

import postoffice.demo.entity.Newspaper;
import postoffice.demo.util.ResultMap;

public interface NewspaperService {
    ResultMap getAll();
    ResultMap search(String value);
    ResultMap insert(Newspaper newspaper);
    ResultMap update(Newspaper newspaper);
    ResultMap deleteById(int id);
}
