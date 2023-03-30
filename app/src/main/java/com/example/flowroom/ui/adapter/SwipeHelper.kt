package com.example.flowroom.ui.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.flowroom.repository.room.Note

class SwipeHelper(onSwiped: (Note) -> Unit): ItemTouchHelper(SwipeCallback(onSwiped))