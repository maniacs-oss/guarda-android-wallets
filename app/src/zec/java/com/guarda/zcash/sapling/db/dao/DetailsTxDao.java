package com.guarda.zcash.sapling.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.guarda.zcash.sapling.db.model.DetailsTxRoom;

import java.util.List;

@Dao
public interface DetailsTxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(DetailsTxRoom... detailsTxRooms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<DetailsTxRoom> detailsTxRooms);

    @Query("SELECT * FROM details_tx order by time desc")
    List<DetailsTxRoom> getTxDetailsListOrdered();

    @Query("SELECT * FROM details_tx where hash is :hash")
    DetailsTxRoom getTxDetails(String hash);

    @Delete
    void delete(DetailsTxRoom detailsTxRoom);

    @Query("DELETE FROM details_tx")
    void dropAll();

}
