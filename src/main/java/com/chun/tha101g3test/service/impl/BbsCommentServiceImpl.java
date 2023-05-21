package com.chun.tha101g3test.service.impl;

import com.chun.tha101g3test.dao.BbsCommentDao;
import com.chun.tha101g3test.model.BbsComment;
import com.chun.tha101g3test.service.BbsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsCommentServiceImpl implements BbsCommentService {

    @Autowired
    private BbsCommentDao bbsCommentDao;
    @Override
    public BbsComment getBbsCommentById(Integer bbsCommentId) {
        return bbsCommentDao.getBbsCommentById(bbsCommentId) ;
    }
}
