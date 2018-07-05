package cn.wenyiguo.web;

import cn.wenyiguo.entity.Product;
import cn.wenyiguo.service.ProductServiceI;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/28 15:35.
 */
@Controller
@RequestMapping("/producter")
@Secured("ROLE_USER")
public class ProductController {

    @Autowired
    private ProductServiceI productServiceI;

    /**
     * 查询所有的产品列表
     * @return
     */
    @RequestMapping("/productQueryAll.do")
    public ModelAndView getProductAlls() {
        List<Product> productAll = productServiceI.getProductAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productAll",productAll);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 跳转到产品保存页面
     * @return
     */
    @RequestMapping("/initproductSave.do")
    public String getInitProductSaves() {
        return "product-add";
    }

    /**
     * 保存产品方法
     * @param product
     * @return
     */
    @RequestMapping("/productSave.do")
    public String getProductSaves(Product product) {
        productServiceI.getProductSave(product);
        return "redirect:/producter/productQueryAll.do";
    }

    /**
     * 跳转到产品修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/initproductUpdate.do")
    public String getInitproductUpdate(String id, Model model) {
        Product product = productServiceI.getProductById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    /**
     * 修改单个产品方法
     * @param product
     * @return
     */
    @RequestMapping("/productUpdate.do")
    public String getProductUpdate(Product product) {
        productServiceI.getProductEait(product);
        return "redirect:/producter/productQueryAll.do";
    }

    /**
     * 删除单个产品的数据
     * @param id
     * @return
     */
    @RequestMapping("/productDelete.do")
    public String getProductDelete(String id) {
        productServiceI.getProductDel(id);
        return "redirect:/producter/productQueryAll.do";
    }

    @RequestMapping("/productFindPage.do")
    public ModelAndView getProductPage(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "3") int pageSize) {
        PageInfo<Product> pageInfo = productServiceI.getProductFindPage(pageNum,pageSize);
        ModelAndView mv = new ModelAndView();
        mv.addObject("productPage",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
}
