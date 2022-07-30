package com.onix.internship.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "note_item")
data class NoteItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "title")
    val name:String,
    @ColumnInfo(name = "content")
    val content:String,
    @ColumnInfo(name="color")
    val color:String
): Serializable
/*enum class colorList(val r:Int,val g:Int, val b:Int) {
    RED(255, 0, 0),
    GREEN(0,255,0),
    DARK_BLUE(0,0,255),
    BLUE(0,204,204),
    PURPLE(204,0,204),
    GREY(128,128,128)
}*/