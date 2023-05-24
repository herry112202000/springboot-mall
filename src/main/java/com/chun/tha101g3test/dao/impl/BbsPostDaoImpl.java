package com.chun.tha101g3test.dao.impl;

import com.chun.tha101g3test.dao.BbsPostDao;
import com.chun.tha101g3test.dto.BbsPostRequest;

import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.rowmapper.BbsPostRowMapper;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BbsPostDaoImpl implements BbsPostDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PersistenceContext
    private Session session;

    @Override
    public BbsPost getBbsPostById(Integer bbsPostId) {
        String sql = "SELECT bbs_post_id, mem_id, bbs_category_id, bbs_tag_id, post_title, post_content, " +
                "create_time, update_time, post_views, post_likes, post_dislikes, post_status " +
                "FROM BBS_POST " +
                "WHERE bbsPostId = :bbsPostId";

        Map<String, Object> map = new HashMap<>();
        map.put("bbsPostId", bbsPostId);
        //查詢這一筆留言的數據, 第三個參數轉換數據的 Rowmapper : 將資料庫所查詢出來的結果 去轉換成 java object
        List<BbsPost> bbsPostList = namedParameterJdbcTemplate.query(sql, map, new BbsPostRowMapper());
        //取得第一個值回傳回去
        if (bbsPostList.size() > 0) {
            return bbsPostList.get(0);
        } else {
            return null;
        }
    }





    @Override
    public Integer createBbsPost(BbsPostRequest bbsPostRequest) {
        String sql = "INSERT INTO BBS_POST (mem_id, bbs_category_id, bbs_tag_id, post_title, post_content, " +
                " post_views, post_likes, post_dislikes, post_status ) " +
                " VALUES ( :memId, :bbsCategoryId, :bbsTagId, :postTitle, :postContent, :postViews, :postLikes, :postDislikes, :postStatus )";


        Map<String, Object> map = new HashMap<>();
        map.put("memId", bbsPostRequest.getMemId());
        map.put("bbsCategoryId", bbsPostRequest.getBbsCategoryId());
        map.put("bbsTagId", bbsPostRequest.getBbsTagId());
        map.put("postTitle", bbsPostRequest.getPostTitle());
        map.put("postContent", bbsPostRequest.getPostContent());
        map.put("postViews", bbsPostRequest.getPostViews());
        map.put("postLikes", bbsPostRequest.getPostLikes());
        map.put("postDislikes", bbsPostRequest.getPostDislikes());
        map.put("postStatus", bbsPostRequest.getPostStatus());





        Date now = new Date();
        map.put("createTime", now);
        map.put("updateTime", now);


        //儲存資料庫自動生成的id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int bbsPostId = keyHolder.getKey().intValue();

        return  bbsPostId;
    }

    @Override
    public Integer deleteBbsPost(Integer bbsPostId) {

        BbsPost bbsPost = session.load(BbsPost.class, bbsPostId);
        session.remove(bbsPost);
        return bbsPostId;
    }


}

