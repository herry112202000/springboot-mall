package com.chun.tha101g3test.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class BbsPostRequest {


    @NotNull
    private String memId;

    @NotNull
    private String bbsCategoryTitle;

    @NotNull
    private String bbsTag;


    @NotNull
    @NotEmpty(message="文章內容: 請勿空白")
    @Size(min=5,max=40,message="文章標題: 長度必需在{min}到{max}之間")
    private String postTitle;
    @NotNull
    @NotEmpty(message="文章內容: 請勿空白")
    @Size(min=5,max=2000,message="文章內容: 長度必需在{min}到{max}之間")
    private String postContent;

    private Integer postStatus;

    private Integer bbsCategoryId;

    private Integer bbsTagId;


    private Integer postViews;

    private Integer postLikes;

    private Integer postDislikes;

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getBbsCategoryId() {
        return bbsCategoryId;
    }

    public void setBbsCategoryId(Integer bbsCategoryId) {
        this.bbsCategoryId = bbsCategoryId;
    }

    public Integer getBbsTagId() {
        return bbsTagId;
    }

    public void setBbsTagId(Integer bbsTagId) {
        this.bbsTagId = bbsTagId;
    }

    public Integer getPostViews() {
        return postViews;
    }

    public void setPostViews(Integer postViews) {
        this.postViews = postViews;
    }

    public Integer getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public Integer getPostDislikes() {
        return postDislikes;
    }

    public void setPostDislikes(Integer postDislikes) {
        this.postDislikes = postDislikes;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getBbsCategoryTitle() {
        return bbsCategoryTitle;
    }

    public void setBbsCategoryTitle(String bbsCategoryTitle) {
        this.bbsCategoryTitle = bbsCategoryTitle;
    }

    public String getBbsTag() {
        return bbsTag;
    }

    public void setBbsTag(String bbsTag) {
        this.bbsTag = bbsTag;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
