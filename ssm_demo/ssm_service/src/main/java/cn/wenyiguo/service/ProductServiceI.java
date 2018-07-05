package cn.wenyiguo.service;

import cn.wenyiguo.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/28 15:31.
 */
public interface ProductServiceI {

    /**
     * 查询所有产品
     * @return
     */
    public List<Product> getProductAll();

    /**
     * 添加产品
     * @param product
     */
    public void getProductSave(Product product);

    /**
     * 查询单个产品的数据
     * @param id
     * @return
     */
    public Product getProductById(String id);

    /**
     * 修改单个产品的数据
     * @param product
     */
    public void getProductEait(Product product);

    /**
     * 删除单个产品的数据
     * @param id
     */
    public void getProductDel(String id);

    public PageInfo<Product> getProductFindPage(int pageNum,int pageSize);
}
