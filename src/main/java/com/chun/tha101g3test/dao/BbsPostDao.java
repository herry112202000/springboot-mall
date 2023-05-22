package com.chun.tha101g3test.dao;


import com.chun.tha101g3test.model.BbsPost;

import java.util.List;

public interface BbsPostDao {
    public BbsPost getBbsPostById(Integer bbsPostId);
    public BbsPost getBbsPostByMemId(Integer memeId);

    public List<BbsPost> selectAll();

    public Integer createBbsPost();

}
