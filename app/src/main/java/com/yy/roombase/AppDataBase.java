package com.yy.roombase;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Author:andy Time:2021/4/13 上午10:06
 */
@Database(entities = {Teacher.class}, version = 3)
abstract class AppDataBase extends RoomDatabase {

    abstract UserDao getDao();

    public static final Migration migrationv_1_to_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Teacher ADD COLUMN address TEXT DEFAULT NULL");
        }
    };

    public static final Migration migrationv_2_to_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Teacher ADD COLUMN mobile TEXT DEFAULT NULL");
        }
    };

    public static final Migration migrationv_1_to_3 = new Migration(1, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Teacher ADD COLUMN address TEXT DEFAULT NULL");
            database.execSQL("ALTER TABLE Teacher ADD COLUMN mobile TEXT DEFAULT NULL");
        }
    };



}
