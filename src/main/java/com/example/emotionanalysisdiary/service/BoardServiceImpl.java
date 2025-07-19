package com.example.emotionanalysisdiary.service;

import com.example.emotionanalysisdiary.dto.BoardDto;
import com.example.emotionanalysisdiary.dto.EmotionRequestDto;
import com.example.emotionanalysisdiary.dto.EmotionResponseDto;
import com.example.emotionanalysisdiary.entity.BoardEntity;
import com.example.emotionanalysisdiary.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ApiService apiService;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, ApiService apiService) {
        this.boardRepository = boardRepository;
        this.apiService = apiService;
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        // 감정 분석 수행
        EmotionRequestDto requestDto = new EmotionRequestDto(boardDto.getContent());
        EmotionResponseDto responseDto = apiService.analyzeEmotion(requestDto);

        // 분석 결과 포함하여 엔티티 생성 및 저장
        BoardEntity boardEntity = new BoardEntity(
                boardDto.getTitle(),
                boardDto.getContent()
        );
        boardEntity.setSentiment(responseDto.getSentiment());
        boardEntity.setScore(responseDto.getScore());

        boardRepository.save(boardEntity);
    }

    @Override
    public List<BoardDto> getAllBoards() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity entity : boardEntities) {
            BoardDto dto = new BoardDto(
                    entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getSentiment(),
                    entity.getScore()
            );
            boardDtoList.add(dto);
        }

        return boardDtoList;
    }

    @Override
    public BoardDto readById(int id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
        return new BoardDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getSentiment(),
                board.getScore()
        );
    }

    @Override
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void updateById(int id, BoardDto boardDto) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        
        boardRepository.save(board);
    }
}
