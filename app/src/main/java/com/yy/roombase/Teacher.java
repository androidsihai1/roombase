package com.yy.roombase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author:andy Time:2021/4/12 下午8:14
 */
@Entity
public class Teacher {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "stu_name")
    public String name;

    @ColumnInfo(name = "stu_score")
    public Float score;

    //version 2加的
    @ColumnInfo(name = "address")
    public String address;

    //version 3加的
    @ColumnInfo(name = "mobile")
    public String mobile;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
