package cn.wenyiguo.dao;

import cn.wenyiguo.entity.Order;
import cn.wenyiguo.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/28 15:25.
 */
@Repository
public interface ProductDaoI {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    public List<Product> getProductAll();

    /**
     * 添加产品
     * @param product
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void getProductSave(Product product);

    /**
     * 修改查询单个产品的数据
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    public Product getProductById(String id);

    /**
     * 修改单个产品的数据
     * @param product
     */
    @Update("update product set productNum = #{productNum},productName = #{productName},cityName = #{cityName},departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus=#{productStatus} where id = #{id}")
    public void getProductEait(Product product);

    /**
     * 删除单个产品的数据
     * @param id
     */
    @Delete("delete from product where id = #{id}")
    public void getProductDel(String id);

}
