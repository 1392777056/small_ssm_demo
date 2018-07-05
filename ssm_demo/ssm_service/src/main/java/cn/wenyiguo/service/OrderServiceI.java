package cn.wenyiguo.service;

import cn.wenyiguo.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 15:02.
 */
public interface OrderServiceI {
    /**
     * 查询所有订单
     * @return
     */
    public List<Order> getOrderAll();

    /**
     * 订单分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Order> getOrderPage(int pageNum,int pageSize);

}
