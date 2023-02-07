package com.example.cloudmonitoringdemo.dto;

import com.example.cloudmonitoringdemo.entity.Tree;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TreeResDto {
  public Long id;

  public String contents;

  public String name;

  public String createdOn;

  public void entityToDto(Tree tree){
    this.id = tree.getId();
    this.contents = tree.getContents();
    this.name = tree.getName();
    this.createdOn = tree.getCreatedON().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

  }
}
