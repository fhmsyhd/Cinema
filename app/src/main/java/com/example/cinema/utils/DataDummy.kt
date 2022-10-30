package com.example.cinema.utils

import com.example.cinema.data.data.source.local.entity.MovieEntity
import java.util.ArrayList

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity("663712",
            "Terrifier 2",
            "After being resurrected by a sinister entity, Art the Clown returns to Miles County where he must hunt down and destroy a teenage girl and her younger brother on Halloween night.  As the body count rises, the siblings fight to stay alive while uncovering the true nature of Art's evil intent.",
            "2022-10-06",
            "/yw8NQyvbeNXoZO6v4SEXrgQ27Ll.jpg",
            6153.144,
        7.5,
            203
        ))
        movies.add(MovieEntity("436270",
            "Black Adam",
            "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.",
            "2022-10-19",
            "/3zXceNTtyj5FLjwQXuPvLYK5YYL.jpg",
            4438.636,
            7.1,
            623
        ))
        return movies
    }
}