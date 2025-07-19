package com.example.emotionanalysisdiary.dto;

public class EmotionRequestDto {
    private String content;

    public EmotionRequestDto() {}//기본생성자

    public EmotionRequestDto(String content) { //생성자
        this.content = content;
    }

    public String getContent() {//게터
        return content;
    }

    public void setContent(String content) {//세터
        this.content = content;
    }
}
