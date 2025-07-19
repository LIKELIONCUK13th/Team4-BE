package com.example.emotionanalysisdiary.controller;

import com.example.emotionanalysisdiary.dto.EmotionResponseDto;
import com.example.emotionanalysisdiary.dto.EmotionRequestDto;
import com.example.emotionanalysisdiary.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<EmotionResponseDto> analyze(@RequestBody EmotionRequestDto requestDto) {
        EmotionResponseDto response = apiService.analyzeEmotion(requestDto);
        return ResponseEntity.ok(response);
    }
}
