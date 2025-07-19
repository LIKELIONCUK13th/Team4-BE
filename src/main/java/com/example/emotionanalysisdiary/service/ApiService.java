package com.example.emotionanalysisdiary.service;

import com.example.emotionanalysisdiary.dto.EmotionRequestDto;
import com.example.emotionanalysisdiary.dto.EmotionResponseDto;

public interface ApiService {
    EmotionResponseDto analyzeEmotion(EmotionRequestDto requestDto);
}
