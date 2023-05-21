package com.chun.tha101g3test.dao.impl;

import com.chun.tha101g3test.dao.BbsPostDao;
import com.chun.tha101g3test.model.BbsComment;
import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.rowmapper.BbsCommentRowMapper;
import com.chun.tha101g3test.rowmapper.BbsPostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BbsPostDaoImpl implements BbsPostDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        @Override
        public BbsPost getBbsPostById(Integer bbsPostId) {
            String sql = "SELECT bbs_post_id, mem_id, bbs_category_id, bbs_tag_id, post_title, post_content, " +
                    "create_time, update_time, post_views, post_likes, post_dislikes, post_status " +
                    "FROM BBS_POST " +
                    "WHERE bbsCommentId = :bbsCommentId";


            Map<String, Object> map = new HashMap<>();
            map.put("bbsPostId", bbsPostId);
            //查詢這一筆留言的數據, 第三個參數轉換數據的rowmapper:將資料庫所查詢出來的結果 去轉換成java object
            List<BbsPost> bbsPostList = namedParameterJdbcTemplate.query(sql, map, new BbsPostRowMapper());

            //取得第一個值回傳回去
            if(bbsPostList.size() >0){
                return bbsPostList.get(0);
            }else {
                return null;
            }
        }

}
