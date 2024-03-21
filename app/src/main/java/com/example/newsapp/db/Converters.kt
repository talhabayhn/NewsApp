package com.example.newsapp.db

import androidx.room.TypeConverter
import com.example.newsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source):String{   // Room cannot use complicated class , like Source
        return source.name                  // Source class converted into String
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}