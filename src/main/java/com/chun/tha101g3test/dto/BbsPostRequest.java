package com.chun.tha101g3test.dto;

import com.chun.tha101g3test.constant.BbsCategory;
import com.chun.tha101g3test.constant.BbsTagCategory;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class BbsPostRequest {


    @NotNull
    private BbsCategory category;

    @NotNull
    private BbsTagCategory bbsTag;


    @NotNull
    @NotEmpty(message = "文章內容: 請勿空白")
    @Size(min = 5, max = 40, message = "文章標題: 長度必需在{min}到{max}之間")
    private String postTitle;
    @NotNull
    @NotEmpty(message = "文章內容: 請勿空白")
    @Size(min = 5, max = 2000, message = "文章內容: 長度必需在{min}到{max}之間")
    private String postContent;


    public BbsCategory getCategory() {
        return category;
    }

    public void setCategory(BbsCategory category) {
        this.category = category;
    }

    public BbsTagCategory getBbsTag() {
        return bbsTag;
    }

    public void setBbsTag(BbsTagCategory bbsTag) {
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