package ming.store.biz.front.service.impl;

import ming.store.biz.front.dao.impl.CategoryDaoImpl;
import ming.store.biz.front.service.CategoryService;
import ming.store.entity.Category;

import java.util.List;

/**
 * Created by Ming on 2017/8/23.
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> queryAll() throws Exception {
        List<Category> list = categoryDao.findAll();
        return list;
    }
    @Override
    public boolean addCategory(Category c) throws Exception {
        return  categoryDao.save(c);
    }
    @Override
    public  boolean updateCategory(Category c) throws Exception {
        return  categoryDao.update( c);
    }

}
