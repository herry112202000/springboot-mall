package com.chun.tha101g3test.controller;

import com.chun.tha101g3test.model.BbsPost;
import com.chun.tha101g3test.service.BbsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
