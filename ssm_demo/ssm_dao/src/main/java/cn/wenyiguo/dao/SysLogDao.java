package cn.wenyiguo.dao;

import cn.wenyiguo.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author 德哲
 * @date 2018/7/2 17:19.
 */
@Repository
public interface SysLogDao {

    @Insert("insert into sys_log(visitTime,username,ip,method) values(#{visitTime},#{username},#{ip},#{method})")
    void savaLogs(SysLog sysLog);
}
