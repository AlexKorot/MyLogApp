package com.onix.internship.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.onix.internship.domain.entity.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface  Dao{
    @Query("SELECT * FROM note_item")
    fun getAllNotes(): Flow<List<NoteItem>>


    @Query("SELECT * FROM note_item ORDER BY title ASC")
    fun getAlphabetizedNote(): Flow<List<NoteItem>>


    @Query("DELETE FROM note_item")
    suspend fun deleteAll()


    @Insert
    suspend fun insertNote(note:NoteItem)

    @Query("DELETE  FROM note_item WHERE id IS :id")
    suspend fun deleteNotes(id:Int)

    @Update
    suspend fun updateNote(note:NoteItem)

}