package com.example.cloudmonitoringdemo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TreeReqDto {
  private Long id;

  private String contents;

  @NotNull(message = "비밀번호는 필수입니다!")
  private String passwd;

  private String name;
}
