package com.chun.tha101g3test.service.impl;

import com.chun.tha101g3test.dao.BbsPostDao;
import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.service.BbsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsPostServiceImpl implements BbsPostService {

    @Autowired
    private BbsPostDao bbsPostDao;
    @Override
    public BbsPost getBbsPostById(Integer bbsPostId) {
        return bbsPostDao.getBbsPostById(bbsPostId)  ;
    }
}
