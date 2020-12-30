package com.example.demo.dao;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Entity.type;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface typeRepository extends JpaRepository<type, String>,
        JpaSpecificationExecutor<type> {

    @Query(value = "select m.title,m.score from type s join product p on s.type = p.type " +
            " join movie m on m.movieID = p.movieID " +
            " WHERE p.type=?1",nativeQuery = true)
    List<Map<String,String>> getMovieByType(String type);

    JSONArray findByMovieNumGreaterThanOrderByMovieNumDesc(Integer index);

    JSONArray findByMovieNumGreaterThanOrderByMovieNumAsc(Integer index);

    @Query(value = "select movie.title,movie.score from movie " +
            "where movie.score>=?1 ORDER BY movie.score DESC " +
            "LIMIT 20",nativeQuery = true)
    List<Map<String,String>> getGreaterScoreMovie(Integer scores);


    @Query(value="select movie.title,movie.score from movie " +
            "where movie.hasPositiveComment='y' ORDER BY movie.score DESC " +
            "LIMIT 20",nativeQuery = true)
    List<Map<String,String>> getPositiveMovie();

}
