package com.example.ddapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Character.class}, version = 4, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract CharacterDAO characterDAO();

    private static volatile RoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static RoomDB getDatabase(Context context){
        if(INSTANCE != null){
            return INSTANCE;
        }
        INSTANCE = buildDatabase(context);
        return INSTANCE;
    }

    static RoomDB buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                RoomDB.class,"character_database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadExecutor().execute(() -> getDatabase(context).characterDAO().insertAll(Character.populate()));
                    }
                })
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
