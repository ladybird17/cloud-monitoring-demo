package com.example.cloudmonitoringdemo.entity;

import com.example.cloudmonitoringdemo.dto.TreeReqDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tree")
@Getter
@RequiredArgsConstructor
public class Tree {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String contents;

  private String passwd;

  private String name;

  @Column(name = "created_on")
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
  @CreationTimestamp
  private LocalDateTime createdON;

  public void dtoToEntity(TreeReqDto treeReqDto){
    this.contents = treeReqDto.getContents();
    this.passwd = treeReqDto.getPasswd();
    this.name = treeReqDto.getName();
  }

  public void updateEntity(TreeReqDto treeReqDto){
    if(treeReqDto.getContents()!=null){
      this.contents = treeReqDto.getContents();
    }
    if(treeReqDto.getName()!=null){
      this.name = treeReqDto.getName();
    }
  }
}
