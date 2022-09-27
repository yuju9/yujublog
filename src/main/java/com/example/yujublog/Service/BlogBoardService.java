package com.example.yujublog.Service;

//import com.example.yujublog.repository.BoardRepository;
import com.example.yujublog.dto.BlogBoardDto;
import com.example.yujublog.repository.BlogBoardRepository;
import com.example.yujublog.model.BlogBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogBoardService {

    @Autowired
    private BlogBoardRepository blogBoardRepository;


    @Transactional
    public void 글쓰기(BlogBoard blogBoard) {
        blogBoardRepository.save(blogBoard);
    }

    @Transactional(readOnly = true)
    public Page<BlogBoard> 글목록(Pageable pageable) {
        return blogBoardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public BlogBoard 글상세보기(int id) {
        return blogBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패"));
    }


    @Transactional
    public void 글삭제하기(int id) {
        blogBoardRepository.deleteById(id);
    }


    @Transactional
    public List<BlogBoardDto> searchPosts(String keyword) {
        List<BlogBoard> blogBoards = blogBoardRepository.findByTitleContaining(keyword);
        List<BlogBoardDto> blogBoardDtoList = new ArrayList<>();

        if (blogBoards.isEmpty()) return blogBoardDtoList;

        for (BlogBoard boardEntity : blogBoards) {
            blogBoardDtoList.add(this.convertEntityToDto(boardEntity));
        }

        return blogBoardDtoList;
    }

    private BlogBoardDto convertEntityToDto(BlogBoard blogBoard) {
        return BlogBoardDto.builder()
                .id(blogBoard.getId())
                .title(blogBoard.getTitle())
                .content(blogBoard.getContent())
                .createDate(blogBoard.getCreateDate())
                .build();
    }
}
