package com.chun.tha101g3test.controller;


import com.chun.springbootmall.model.Product;
import com.chun.tha101g3test.model.BbsComment;
import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.rowmapper.BbsPostRowMapper;
import com.chun.tha101g3test.service.BbsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BbsCommentController {

    @Autowired
    private BbsCommentService bbsCommentService;

    @GetMapping("/bbscomments/{bbsCommentId}")
    public ResponseEntity<BbsComment> getBbsComment (@PathVariable Integer bbsCommentId){
        System.out.println(bbsCommentId);

//        return null;
        BbsComment bbsComment = bbsCommentService.getBbsCommentById(bbsCommentId);
        if(bbsComment != null){
            return ResponseEntity.status(HttpStatus.OK).body(bbsComment);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/bbscomments")
    public ResponseEntity<BbsComment> addData(@RequestParam("bbsCommentId") Integer bbsCommentId) {

//        System.out.println(String.format("bbsCommentId: %s",bbsCommentId));
        BbsComment bbsComment = new BbsComment();

        bbsComment.getBbsCommentId();
        bbsComment.getCommentContent();
        bbsComment.getBbsPostId();
        bbsComment.getUpdateTime();
        bbsComment.getCreateTime();
        bbsComment.getMemId();
        bbsComment.getCommentStatus();
//        bbsComment.setBbsTagId(01);
//        bbsComment.setPostTitle("這是第一篇文章的標題");
//        bbsComment.setPostContent("發文內容~~~~");
//        bbsComment.setPostViews(322);
//        bbsComment.setPostLikes(20);
//        bbsComment.setPostDislikes(5);
//        bbsComment.setPostStatus(1);
//        bbsComment.setUpdateTime();


        return ResponseEntity.status(HttpStatus.OK).body(bbsComment);
    }



}
