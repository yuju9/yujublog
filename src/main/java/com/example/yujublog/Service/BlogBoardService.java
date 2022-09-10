package com.example.yujublog.Service;

//import com.example.yujublog.repository.BoardRepository;
import com.example.yujublog.repository.BlogBoardRepository;
import com.example.yujublog.model.BlogBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

}
