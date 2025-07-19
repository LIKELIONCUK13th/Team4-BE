package com.example.emotionanalysisdiary.controller;

import com.example.emotionanalysisdiary.dto.BoardDto;
import com.example.emotionanalysisdiary.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // POST 요청: 게시글 저장
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return ResponseEntity.ok("게시글이 등록되었습니다");
    }

    // GET 요청: 게시글 전체 조회
    @GetMapping("/read")
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/read/{id}")
    public BoardDto readBoard(@PathVariable int id) {
        return boardService.readById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        boardService.updateById(id,boardDto);
        return ResponseEntity.ok("게시글 수정됨");
    }
}

