package com.onix.internship.notes

import androidx.annotation.WorkerThread
import com.onix.internship.db.Dao
import com.onix.internship.domain.entity.NoteItem
import kotlinx.coroutines.flow.Flow

class NoteRepository (private val noteDao: Dao) {


    val allNote: Flow<List<NoteItem>> = noteDao.getAlphabetizedNote()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertNote(note:NoteItem){
    }
}