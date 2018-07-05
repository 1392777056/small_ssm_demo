package cn.wenyiguo.dao;

import cn.wenyiguo.entity.Role;
import cn.wenyiguo.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/6/29 22:30.
 */
@Repository
public interface SysUserDaoI {

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(column = "id",property = "roles",many = @Many(select = "cn.wenyiguo.dao.RoleDaoI.getUserAllById" ))
    })
    SysUser getFindSysUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> getUserFindAll();

    @Insert("insert into sys_user (username,email,password,phoneNum,status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void getSaveUser(SysUser sysUser);

    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(column = "id",property = "roles",many = @Many(select = "cn.wenyiguo.dao.RoleDaoI.getUserAllById"))
    })
    SysUser getFindUserDetils(String id);

    @Insert("insert into sys_role (roleName, roleDesc) values (#{roleName}, #{roleDesc})")
    void getSavaRole(Role role);

    @Select("select * from sys_role")
    List<Role> getFindRolesAll();

    @Delete("delete from sys_user_role where userId = #{userId}")
    void getDelRoles(String userId);

    @Insert("insert into sys_user_role (userId,roleId) values(#{userId},#{roleId})")
    void getsavaRles(@Param("userId") String userId,@Param("roleId") String roleId);
}
