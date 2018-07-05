package cn.wenyiguo.service.impl;

import cn.wenyiguo.dao.SysLogDao;
import cn.wenyiguo.entity.SysLog;
import cn.wenyiguo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 德哲
 * @date 2018/7/2 17:17.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private SysLogDao sysLogDao;

    public void savaLogs(SysLog sysLog) {
        sysLogDao.savaLogs(sysLog);
    }
}
