package com.chun.tha101g3test.controller;

import com.chun.springbootmall.model.Product;
import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.service.BbsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsPostController {

    @Autowired
    private BbsPostService bbsPostService;

    @GetMapping("/bbsposts/{bbsPostId}")
    public ResponseEntity<BbsPost> getBbsPost(Integer bbsPostId){
        BbsPost bbsPost = bbsPostService.getBbsPostById(bbsPostId);
        if(bbsPost != null){
            return ResponseEntity.status(HttpStatus.OK).body(bbsPost);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/bbsposts")
    public ResponseEntity<BbsPost> addData(@RequestParam("bbsPostId") Integer bbsPostId) {

//        System.out.println(String.format("bbsPostId: %s",bbsPostId));
        BbsPost bbsPost = new BbsPost();

//        bbsPost.setBbsPostId(1);
//        bbsPost.setMemId(0001);
//        bbsPost.setBbsCategoryId(001);
//        bbsPost.setBbsTagId(01);
//        bbsPost.setPostTitle("這是第一篇文章的標題");
//        bbsPost.setPostContent("發文內容~~~~");
//        bbsPost.setPostViews(322);
//        bbsPost.setPostLikes(20);
//        bbsPost.setPostDislikes(5);
//        bbsPost.setPostStatus(1);
//        bbsPost.setUpdateTime();


        return ResponseEntity.status(HttpStatus.OK).body(bbsPost);
    }


}
