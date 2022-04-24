package com.cos.blog.controller.api;

import com.cos.blog.configuration.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
public class BoardApiController {

    @Autowired
    BoardService boardService;

    @PostMapping("api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println("BoardApiController : save 호출 됨");
        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail principal) throws IllegalAccessException {
        System.out.println("BoardApiController : delete 호출 됨");
        Board board = boardService.글상세보기(id);
        if(!board.getUser().getUsername().equals(principal.getUsername())){
            throw new IllegalAccessException("글 삭제 권한이 없습니다.");
        }
        boardService.글삭제(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
