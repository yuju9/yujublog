package com.example.yujublog.Controller;

import com.example.yujublog.Service.BlogBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogBoardController {

    @Autowired
    private BlogBoardService blogBoardService;


    @GetMapping({"/mainBoard"})
    public String mainBoard(Model model, @PageableDefault(sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", blogBoardService.글목록(pageable));
        return "mainBoard";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", blogBoardService.글상세보기(id));
        return "boardDetail";
    }
}
