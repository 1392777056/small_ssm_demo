package it.heima.service.impl;

import it.heima.dao.ItemDao;
import it.heima.domain.Item;
import it.heima.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 德哲
 * @date 2018/6/25 17:06.
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemDao itemDao;

    public Item getItemById(Integer id) {
        return itemDao.getItemById(id);
    }
}
