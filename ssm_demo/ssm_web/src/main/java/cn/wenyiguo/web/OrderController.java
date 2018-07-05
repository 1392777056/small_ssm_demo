package cn.wenyiguo.web;

import cn.wenyiguo.entity.Order;
import cn.wenyiguo.service.OrderServiceI;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 15:00.
 */
@Controller
@RequestMapping("/orderer")
public class OrderController {

    @Autowired
    private OrderServiceI orderServiceI;

    /**
     * 查所有订单
     * @return
     */
    @RequestMapping("/orderQueryAll.do")
    public ModelAndView getOrdersAll(){
        List<Order> orderAll = orderServiceI.getOrderAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("orderList",orderAll);
        mv.setViewName("order-list");
        return mv;

    }


    @RequestMapping("/findOrderPage.do")
    public ModelAndView getOrderPages(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Order> pageInfo = orderServiceI.getOrderPage(pageNum,pageSize);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orderPage",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

}
