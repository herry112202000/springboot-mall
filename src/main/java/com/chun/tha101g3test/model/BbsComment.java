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
public class BbsComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_comment_id")
    private Integer bbsCommentId;  //論壇留言流水號
    @Column(name = "bbs_post_id")
    private Integer bbsPostId;    //論壇文章流水號
    @Column(name = "mem_id",insertable = false)
    private Integer memId;       //會員編號
    @Column(name = "comment_content")
    private String commentContent; //留言內容
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;  //新增時間
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;  //修改時間
    @Column(name = "comment_status")
    private  Integer commentStatus; //留言狀態


    @ManyToOne
    @JoinColumn(name = "bbs_post_id", updatable = false)
    private BbsPost bbsPost; //關聯-論壇文章流水號


    @ManyToOne
    @JoinColumn(name = "mem_id", updatable = false)
    private Member member; //關聯-會員編號
}
