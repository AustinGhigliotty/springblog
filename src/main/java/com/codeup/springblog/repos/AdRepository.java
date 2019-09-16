package com.codeup.springblog.repos;

import com.codeup.springblog.Models.Ad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {
    Ad findByTitle(String title);

    @Query("from Ad a where a.title like %:term%")
    List<Ad> searchByTitleLike(@Param("term") String term);
}
