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
public class BbsPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_post_id")
    private Integer bbsPostId;
    @Column(name = "mem_id ,insertable = false")
    private Integer memId;
    @Column(name = "bbs_category_id ,insertable = false")
    private Integer bbsCategoryId;
    @Column(name = "bbs_tag_id ,insertable = false")
    private Integer bbsTagId;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_content")
    private String postContent;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;
    @Column(name = "post_views")
    private Integer postViews;
    @Column(name = "post_likes")
    private Integer postLikes;
    @Column(name = "post_dislikes")
    private Integer postDislikes;
    @Column(name = "post_status")
    private Integer postStatus;

}
