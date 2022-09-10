package com.example.yujublog.repository;

import com.example.yujublog.model.BlogBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogBoardRepository extends JpaRepository<BlogBoard, Integer> {
}
