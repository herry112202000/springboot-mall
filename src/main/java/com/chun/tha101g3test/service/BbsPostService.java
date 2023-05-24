package com.chun.tha101g3test.service;

import com.chun.tha101g3test.dto.BbsPostRequest;
import com.chun.tha101g3test.model.BbsPost;

public interface BbsPostService {
    public BbsPost getBbsPostById(Integer bbsPostId);



    public Integer createBbsPost(BbsPostRequest bbsPostRequest);

    public Integer deleteBbsPost(Integer bbsPostId);
}
