package com.chun.tha101g3test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_comment_id")
    private Integer bbsCommentId;
    @Column(name = "bbs_post_id",insertable = false)
    private Integer bbsPostId;
    @Column(name = "mem_id",insertable = false)
    private Integer memId;
    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;
    @Column(name = "comment_status")
    private  Integer commentStatus;
}
