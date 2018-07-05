package it.heima.web;

import it.heima.domain.Item;
import it.heima.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 德哲
 * @date 2018/6/25 17:08.
 */
@Controller
@RequestMapping("/itemcont")
public class ItemConterller {

    @Autowired
    private IItemService iItemService;

    @RequestMapping("/itheima.do")
    public ModelAndView getItems(Integer id) {
        Item itemById = iItemService.getItemById(id);
        ModelAndView view = new ModelAndView();
        view.addObject("item",itemById);
        view.setViewName("itemDetail");
        return view;
    }

}
