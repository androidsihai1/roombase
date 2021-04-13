package com.yy.roombase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Author:andy Time:2021/4/12 下午8:21
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM Teacher")
    List<Teacher> getAllUser();


    @Query("SELECT * FROM Teacher where id in(:usderIds)")
    List<Teacher> getUserLimit(int usderIds[]);

    @Insert
    void addUser(Teacher teacher);

    @Delete
    void deleteUser(Teacher teacher);

}
