package com.example.emotionanalysisdiary.service;

import com.example.emotionanalysisdiary.dto.EmotionResponseDto;
import com.example.emotionanalysisdiary.dto.EmotionRequestDto;
import com.google.cloud.language.v1.*;
import com.google.cloud.language.v1.Document.Type;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service

public class ApiServiceImpl implements ApiService {

    @Override
    public EmotionResponseDto analyzeEmotion(EmotionRequestDto requestDto) {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {
            Document doc = Document.newBuilder()
                    .setContent(requestDto.getContent())
                    .setType(Type.PLAIN_TEXT).build();

            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

            return new EmotionResponseDto(
                    sentiment.getScore() > 0 ? "긍정" : sentiment.getScore() < 0 ? "부정" : "중립",
                            sentiment.getScore()
            );
        } catch (IOException e) {
            throw new RuntimeException("감정 분석 API 호출 실패", e);
        }
    }
}

