package com.chun.tha101g3test.core;

import java.util.List;

public interface CoreDao <P, I,S> {
    int insert(P pojo);
    int deleteById(I id);
    int update(P pojo);
    P selectById(I id);
    List<P> selectBackAll(S key, S type , Integer id);
}
