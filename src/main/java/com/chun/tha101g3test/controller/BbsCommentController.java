package com.chun.tha101g3test.controller;


import com.chun.springbootmall.model.Product;
import com.chun.tha101g3test.model.BbsComment;
import com.chun.tha101g3test.service.BbsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BbsCommentController {

    @Autowired
    private BbsCommentService bbsCommentService;

//    @GetMapping("/bbscomments/{bbsCommentId}")
//    public ResponseEntity<BbsComment> getBbsComment (@PathVariable Integer bbsCommentId){
////        BbsComment bbsComment = bbsCommentService.getBbsCommentById(bbsCommentId);
////        if(bbsComment != null){
////            return ResponseEntity.status(HttpStatus.OK).body(bbsComment);
////        }else{
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////        }
//        System.out.println("OLK");
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }


//    @GetMapping("/bbscomments/{bbsCommentId}")
//    public ResponseEntity<Product> getProduct(@PathVariable Integer bbsCommentId){
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//    }
}
