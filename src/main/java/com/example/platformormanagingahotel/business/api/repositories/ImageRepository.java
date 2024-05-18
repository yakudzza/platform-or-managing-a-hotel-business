package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.entities.Image;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long>{
}
