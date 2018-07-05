package cn.wenyiguo.dao;

import cn.wenyiguo.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/7/1 16:43.
 */
public interface PermissionDao {

    @Select("select sp.* from sys_permission sp,sys_role_permission srp where srp.permissionid = sp.id and srp.roleid = #{id}")
    public List<Permission> findByRoleId(String id);

}
