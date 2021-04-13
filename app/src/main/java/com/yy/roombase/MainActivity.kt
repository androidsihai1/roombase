package com.yy.roombase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataBase =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "room_base")
                .addMigrations(
                    AppDataBase.migrationv_1_to_2,
                    AppDataBase.migrationv_2_to_3,
                    AppDataBase.migrationv_1_to_3
                )
                .allowMainThreadQueries().build()
        val dao = dataBase.dao
        Thread(Runnable {
            for (i in 0..20) {
                val teacher = Teacher()
                teacher.name = "dahai_test$i"
                teacher.score = (100 + i).toFloat()
                dao.addUser(teacher)
            }

            val allUser = dao.allUser
            allUser.forEach {
                Log.d("sihai", "item=$it")
            }
            val teacher = Teacher()
            teacher.name = "dahai_test0"
            teacher.score = 100f
            dao.deleteUser(teacher)

            val userLimit = dao.getUserLimit(mutableListOf(0, 3, 5, 6, 8).toIntArray())
            userLimit.forEach {
                Log.d("sihai", "limit =$it")
            }
        }).start()
    }
}