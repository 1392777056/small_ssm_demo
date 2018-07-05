package cn.wenyiguo.service.impl;

import cn.wenyiguo.dao.SysUserDaoI;
import cn.wenyiguo.entity.Role;
import cn.wenyiguo.entity.SysUser;
import cn.wenyiguo.service.SysUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 22:29.
 */
@Service("sysUsersService")
public class SysUserServiceImpl implements SysUserServiceI {

    @Autowired
    private SysUserDaoI userDaoI;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 给保存的用户密码加密
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("方法执行！！");
        Collection<GrantedAuthority> list = new ArrayList<>();
        /*list.add(new SimpleGrantedAuthority("ROLE_USER"));
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));*/
        SysUser sysUser = userDaoI.getFindSysUsername(username);
        List<Role> roles = sysUser.getRoles();
        if (roles != null && roles.size() > 0)
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        User user = new User(username,sysUser.getPassword(),list);
        return user;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<SysUser> getUserFindAll() {
        return userDaoI.getUserFindAll();
    }

    /**
     * 添加用户
     * @param sysUser
     */
    public void getSaveUser(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        userDaoI.getSaveUser(sysUser);
    }

    /**
     * 查询用户详情
     * @param id
     * @return
     */
    public SysUser getFindUserDetils(String id) {
        return userDaoI.getFindUserDetils(id);
    }

    /**
     * 添加角色
     * @param role
     */
    public void getSavaRole(Role role) {
        userDaoI.getSavaRole(role);
    }

    public List<Role> getFindRolesAll() {
        return userDaoI.getFindRolesAll();
    }


    public void getSavarrr(String userId, String[] ids) {
        userDaoI.getDelRoles(userId);
        if (ids != null) {
            for (String roleId : ids) {
                userDaoI.getsavaRles(userId,roleId);
            }
        }

    }
}
