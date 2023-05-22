package com.chun.tha101g3test.dao.impl;

import com.chun.springbootmall.model.Product;
import com.chun.springbootmall.rowmapper.ProductRowMapper;
import com.chun.tha101g3test.dao.BbsCommentDao;
import com.chun.tha101g3test.model.BbsComment;
import com.chun.tha101g3test.rowmapper.BbsCommentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BbsCommentDaoImpl implements BbsCommentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public BbsComment getBbsCommentById(Integer bbsCommentId) {
        String sql = "SELECT bbs_comment_id, bbs_post_id, mem_id, comment_content, create_time, update_time, " +
                "comment_status " +
                "FROM BBS_COMMENT " +
                "WHERE bbs_comment_id = :bbsCommentId";


        Map<String, Object> map = new HashMap<>();
        map.put("bbsCommentId", bbsCommentId);
        //查詢這一筆留言的數據, 第三個參數轉換數據的rowmapper:將資料庫所查詢出來的結果 去轉換成java object
        List<BbsComment> bbsCommentList = namedParameterJdbcTemplate.query(sql, map, new BbsCommentRowMapper());

        //取得第一個值回傳回去
        if(bbsCommentList.size() >0){
            return bbsCommentList.get(0);
        }else {
            return null;
        }
    }
}
