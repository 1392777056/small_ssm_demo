package cn.wenyiguo.dao;

import cn.wenyiguo.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 德哲
 * @date 2018/7/1 16:32.
 */
public interface RoleDaoI {

    @Select("select sr.* from sys_user_role sur,sys_role sr where sur.userid = #{id} and sur.roleid = sr.id")
    @Results({
            @Result(property = "permissions",column = "id",many = @Many(select = "cn.wenyiguo.dao.PermissionDao.findByRoleId"))
    })
    public List<Role> getUserAllById(String id);


}
