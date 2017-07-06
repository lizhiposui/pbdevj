package cn.bdqn.tangcco.grade.dao;

import cn.bdqn.tangcco.entity.Grade;


/**
 * Created by Administrator on 2017/6/29.
 */
public interface GradeDao {
    Grade queryGradeById(int id);
    int deleteGrade(int id);
}
