package com.chun.tha101g3test.rowmapper;


import com.chun.tha101g3test.model.BbsComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//泛型<Product>:表示要轉換成Product這個java class
public class BbsCommentRowMapper implements RowMapper<BbsComment> {
    @Override
    public BbsComment mapRow(ResultSet rs, int rowNum) throws SQLException {

        //可以從rs參數裡,取得資料庫查詢出來的數據,將她儲存在product變數裡
        BbsComment bbsComment = new BbsComment();

        //取得product_id這個欄位的數據
        bbsComment.setBbsCommentId(rs.getInt("bbs_comment_id"));
        bbsComment.setBbsPostId(rs.getInt("bbs_post_id"));
        bbsComment.setMemId(rs.getInt("mem_id"));
        bbsComment.setCommentContent(rs.getString("comment_content"));
        bbsComment.setCreateTime(rs.getTimestamp("create_time"));
        bbsComment.setUpdateTime(rs.getTimestamp("update_time"));
        bbsComment.setCommentStatus(rs.getInt("comment_status"));
        return bbsComment;
    }
}
