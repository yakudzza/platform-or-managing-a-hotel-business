package com.example.platformormanagingahotel.business.api.repositories;

import com.example.platformormanagingahotel.business.api.entities.Image;
import jakarta.transaction.Transactional;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByOriginalFileName(String name);
}
