package com.rajsuvariya.popularmoviesstage1.data.remote.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

/**
 * Created by @raj on 12/06/18.
 */
@Entity(tableName = "genres", primaryKeys = {"id", "movieId"},
        foreignKeys = @ForeignKey(entity = MovieDetailsOutputModel.class,
                parentColumns = "id",
                childColumns = "movieId",
                onDelete = ForeignKey.CASCADE))
public class Genre {

    @SerializedName("id")
    @Expose
    @NotNull
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    @NotNull
    private Integer movieId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}