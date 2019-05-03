package edu.cuit.autumn.mapper;

import edu.cuit.autumn.entity.Teacher;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

    /**
     * 查找所有老师
     * @return List<User>
     */
    @Select("select * from teacher")
    List<Teacher> getAllTeacher();

    /**
     * 根据teacherName模糊查找用户
     * @param teacherName
     * @return User
     */
    @Select("select * from teacher where teacher_name like %#{teacherName}%")
    List<Teacher> getTeacherByName(String teacherName);

    /**
     * 根据teacherId删除老师
     * @param teacherId
     */
    @Delete("delete from teacher where teacher_id=#{teacherId}")
    void deleteTeacher(String teacherId);

    /**
     * 增加老师
     */
    @Insert("insert into teacher values(#{teacherId},#{userId},#{teacherName},#{teacherSex},#{teacherBirthday},#{teacherPosition},#{teacherPhone})")
    void insertTeacher(Teacher teacher);

    /**
     * 修改老师信息
     * @param teacher
     */
    @Update("update teacher set teacher_name=#{teacherName},teacher_sex=#{teacherSex},teacher_brithday=#{teacherBirthday},teacher_position=#{teacherPosition},teacher_phone=#{teacherPhone} where teacher_id=#{teacherId}")
    void updateTeacher(Teacher teacher);

}