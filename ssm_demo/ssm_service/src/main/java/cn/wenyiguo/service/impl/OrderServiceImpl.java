package cn.wenyiguo.service.impl;

import cn.wenyiguo.dao.OrderDaoI;
import cn.wenyiguo.entity.Order;
import cn.wenyiguo.service.OrderServiceI;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 15:04.
 */
@Service
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private OrderDaoI orderDaoI;

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> getOrderAll() {
        return orderDaoI.getOrderAll();
    }

    /**
     * 订单进行分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Order> getOrderPage(int pageNum, int pageSize) {
        // 设置当前条数
        PageHelper.startPage(pageNum,pageSize);
        // 查询所有数据，不用加limit rownum
        List<Order> orderAll = orderDaoI.getOrderAll();
        // 将查询的结果 封装到pageInfo中
        PageInfo<Order> pageInfo = new PageInfo<>(orderAll);
        return pageInfo;
    }
}
