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
public class Bbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_category_id")
    private Integer bbsCategoryId;  //論壇看板流水號
    @Column(name = "bbs_category_title")
    private String bbsCategoryTitle; //論壇看板名稱
}
