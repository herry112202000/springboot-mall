package com.chun.tha101g3test.dao;

import com.chun.tha101g3test.dto.BbsPostRequest;
import com.chun.tha101g3test.model.BbsPost;



public interface BbsPostDao{
     BbsPost getBbsPostById(Integer bbsPostId);

     Integer createBbsPost(BbsPostRequest bbsPostRequest);

    Integer deleteBbsPost(Integer bbsPostId);


}
