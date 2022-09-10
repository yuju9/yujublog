package com.example.yujublog.Controller;

import com.example.yujublog.Service.BlogBoardService;
import com.example.yujublog.dto.ResponseDto;
import com.example.yujublog.model.BlogBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogBoardApiController {

    @Autowired
    private BlogBoardService blogBoardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody BlogBoard blogBoard) {
        blogBoardService.글쓰기(blogBoard);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        blogBoardService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
