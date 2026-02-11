package com.embarkx.reviewms.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long companyId); //created  a  method in review Repository sice  w e have  only  byid
}
