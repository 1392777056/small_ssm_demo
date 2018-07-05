package cn.wenyiguo.service;

import cn.wenyiguo.entity.Role;
import cn.wenyiguo.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 22:27.
 */
public interface SysUserServiceI extends UserDetailsService {

    List<SysUser> getUserFindAll();

    void getSaveUser(SysUser sysUser);

    SysUser getFindUserDetils(String id);

    void getSavaRole(Role role);

    List<Role> getFindRolesAll();

    void getSavarrr(String userId, String[] ids);
}
