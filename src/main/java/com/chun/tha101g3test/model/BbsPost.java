package com.chun.tha101g3test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BbsPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_post_id")
    private Integer bbsPostId; //論壇文章流水號
    @Column(name = "mem_id")
    private Integer memId;   //會員編號
    @Column(name = "bbs_category_id")
    private Integer bbsCategoryId;  //論壇看板流水號
    @Column(name = "bbs_tag_id")
    private Integer bbsTagId;  //文章標籤流水號
    @Column(name = "post_title")
    private String postTitle;  //文章標題
    @Column(name = "post_content")
    private String postContent; //文章內容
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime; //新增時間
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime; //修改時間
    @Column(name = "post_views")
    private Integer postViews;  //文章總瀏覽人數
    @Column(name = "post_likes")
    private Integer postLikes;  //文章按讚人數
    @Column(name = "post_dislikes")
    private Integer postDislikes; //文章倒讚人數
    @Column(name = "post_status")
    private Integer postStatus;  //文章狀態


    @ManyToOne
    @JoinColumn(name = "mem_id", updatable = false)
    private Member member; //關聯-會員編號

    @ManyToOne
    @JoinColumn(name = "bbs_category_id", updatable = false)
    private Bbs bbs; //關聯-論壇看板流水號

    @ManyToOne
    @JoinColumn(name = "bbs_tag_id", updatable = false)
    private BbsTag bbsTag; //關聯-文章標籤流水號




}
