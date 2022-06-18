package com.onix.internship.model

import android.graphics.Rect

 class Board {
    val cells  = Array(3) { Array(3) { Rect() } }
    val cellsData = Array(3) { Array(3) { "" } }

}