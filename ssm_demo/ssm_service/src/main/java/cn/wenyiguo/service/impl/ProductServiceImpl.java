package cn.wenyiguo.service.impl;

import cn.wenyiguo.dao.ProductDaoI;
import cn.wenyiguo.entity.Product;
import cn.wenyiguo.service.ProductServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/28 15:32.
 */
@Service
public class ProductServiceImpl implements ProductServiceI {

    @Autowired
    private ProductDaoI productDaoI;

    /**
     * 查询所有商品
     * @return
     */
    public List<Product> getProductAll() {
        return productDaoI.getProductAll();
    }

    /**
     * 添加产品
     * @param product
     */
    public void getProductSave(Product product) {
        productDaoI.getProductSave(product);
    }

    /**
     * 修改查询单个产品的数据
     * @param id
     * @return
     */
    public Product getProductById(String id) {
        return productDaoI.getProductById(id);
    }

    /**
     * 修改单个产品的数据
     * @param product
     */
    public void getProductEait(Product product) {
        productDaoI.getProductEait(product);
    }

    /**
     * 删除单个产品的数据
     * @param id
     */
    public void getProductDel(String id) {
        productDaoI.getProductDel(id);
    }


    public PageInfo<Product> getProductFindPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productAll = productDaoI.getProductAll();

        PageInfo<Product> page = new PageInfo<>(productAll);
        return page;
    }
}
