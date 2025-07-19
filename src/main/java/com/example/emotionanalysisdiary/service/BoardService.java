package com.example.emotionanalysisdiary.service;

import com.example.emotionanalysisdiary.dto.BoardDto;
import com.example.emotionanalysisdiary.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    void createBoard(BoardDto boardDto);
    BoardDto readById(int id);
    List<BoardDto> getAllBoards();
    void updateById(int id, BoardDto boardDto);
    void deleteBoard(int id);
}

