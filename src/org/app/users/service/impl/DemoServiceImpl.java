package org.app.users.service.impl;

import java.util.List;

import org.common.base.BaseDao;
import org.springframework.stereotype.Repository;
import org.app.users.bean.demo;
import org.app.users.service.DemoService;
@Repository
public class DemoServiceImpl extends BaseDao implements DemoService{
	/**
     * 查询
     * 
     * @param uid
     * @return
     */
    public List<demo> getUserByUid() {
        return getSqlMapClientTemplate().queryForList("selectDemo");
    }

}	
