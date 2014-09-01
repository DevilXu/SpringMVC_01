package org.swinglife.controller.service.impl;

import java.util.List;

import org.common.base.BaseDao;
import org.springframework.stereotype.Repository;
import org.swinglife.controller.bean.demo;
import org.swinglife.controller.service.DemoService;
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
