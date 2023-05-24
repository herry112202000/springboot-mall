package com.chun.tha101g3test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BbsTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_tag_id")
    private Integer bbsTagId;  //文章標籤流水號
    @Column(name = "bbs_tag")
    private String bbsTag;   //文章標籤名稱
}
