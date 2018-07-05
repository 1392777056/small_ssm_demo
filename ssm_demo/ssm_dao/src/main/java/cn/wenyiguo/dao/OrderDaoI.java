package cn.wenyiguo.dao;

import cn.wenyiguo.entity.Order;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 15:04.
 */
@Repository
public interface OrderDaoI {

    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results(
         value = {@Result(property = "product", column = "productId", one = @One(select = "cn.wenyiguo.dao.ProductDaoI.getProductById"))
    })
    public List<Order> getOrderAll();
}
