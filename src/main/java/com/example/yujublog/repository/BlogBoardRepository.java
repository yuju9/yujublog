package com.example.yujublog.repository;

import com.example.yujublog.model.BlogBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogBoardRepository extends JpaRepository<BlogBoard, Integer> {
    List<BlogBoard> findByTitleContaining(String keyword);
}
