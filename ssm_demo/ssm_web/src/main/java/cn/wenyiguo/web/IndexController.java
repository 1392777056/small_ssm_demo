package cn.wenyiguo.web;

import cn.wenyiguo.entity.Role;
import cn.wenyiguo.entity.SysUser;
import cn.wenyiguo.service.SysUserServiceI;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 22:25.
 */
@Controller
@RequestMapping("/indexUsers")

public class IndexController {

    @Autowired
    private SysUserServiceI sysUserServiceI;

    @RequestMapping("/indexUser.do")
    public ModelAndView getIndexUser() {

        /*SecurityContext sc = SecurityContextHolder.getContext();
        Authentication authentication = sc.getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());*/

        List<SysUser> list = sysUserServiceI.getUserFindAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userlist",list);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/initsave.do")
    public String getInitSava(){
        return "user-add";
    }

    @RequestMapping("/saveUser.do")
    public String getSaveUsers(SysUser sysUser) {
        sysUserServiceI.getSaveUser(sysUser);
        return "redirect:/indexUsers/indexUser.do";
    }

    @RequestMapping("/findUserDetils.do")
    public ModelAndView getFindUserDetiler(String id){
        SysUser user = sysUserServiceI.getFindUserDetils(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findInitRoles.do")
    public ModelAndView getInitSaveRole(String id){
        // 通过id 查询用户
        SysUser sysUser = sysUserServiceI.getFindUserDetils(id);
        // 查询用户拥有的角色
        List<Role> roles = sysUser.getRoles();
        // 利用字符串拼接来显示用户的角色名称
        StringBuffer sf = new StringBuffer();
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                sf.append(role.getRoleName());
                sf.append(",");
            }
        }
        sf.substring(0,sf.length()-1);
        String roleNameStr = sf.toString();
        System.out.println(roleNameStr);
        // 查询出所有的角色
        List<Role> list = sysUserServiceI.getFindRolesAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",sysUser);
        mv.addObject("roleNameStr",roleNameStr);
        mv.addObject("roleList",list);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/savaRoleAllss.do")
    public String getRoSaves(String userId,String[] ids ){
        sysUserServiceI.getSavarrr(userId,ids);
        return "redirect:/indexUsers/indexUser.do";
    }

    @RequestMapping("/findRoles.do")
    public String getFindRolsss(Model model) {
        List<Role> list = sysUserServiceI.getFindRolesAll();
        model.addAttribute("roleList",list);
        return "role-list";
    }

    @RequestMapping("/initsaveroles.do")
    public String getinitsaveroles(){
        return "role-add";
    }

    @RequestMapping("/saveRoles.do")
    public String getSaveRole(Role role) {
        sysUserServiceI.getSavaRole(role);
        return "redirect:/indexUsers/findRoles.do";
    }


}
