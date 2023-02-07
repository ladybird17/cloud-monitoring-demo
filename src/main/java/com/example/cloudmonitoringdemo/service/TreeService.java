package com.example.cloudmonitoringdemo.service;

import com.example.cloudmonitoringdemo.dto.TreeReqDto;
import com.example.cloudmonitoringdemo.dto.TreeResDto;
import com.example.cloudmonitoringdemo.entity.Tree;
import com.example.cloudmonitoringdemo.repository.TreeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TreeService {
  @Autowired
  TreeRepository treeRepository;

  public List<TreeResDto> getTree(){
    List<Tree> treeList = treeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    List<TreeResDto> treeResList = new ArrayList<>();
    treeList.forEach(o -> {
      TreeResDto treeResDto = new TreeResDto();
      treeResDto.entityToDto(o);
      treeResList.add(treeResDto);
    });
    return treeResList;
  }

  public TreeResDto postOrnament(TreeReqDto treeReqDto) throws Exception {
    Tree tree = new Tree();
    tree.dtoToEntity(treeReqDto);
    tree = treeRepository.save(tree);
    return getOrnament(tree.getId());
  }

  public TreeResDto updateOrnament(TreeReqDto treeReqDto) throws Exception {
    Tree tree = getTreeOrThrowException(treeReqDto.getId());
    if(!tree.getPasswd().equals(treeReqDto.getPasswd())){
      throw new Exception();
    }
    tree.updateEntity(treeReqDto);
    treeRepository.save(tree);
    return getOrnament(tree.getId());
  }

  public ResponseEntity<?> deleteOrnament(Long id, TreeReqDto treeReqDto) throws Exception {
    Tree tree = getTreeOrThrowException(id);
    if(!tree.getPasswd().equals(treeReqDto.getPasswd())){
      throw new Exception();
    }
    treeRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);
  }

  public TreeResDto getOrnament(Long id) throws Exception {
    Tree tree = getTreeOrThrowException(id);
    TreeResDto treeResDto = new TreeResDto();
    treeResDto.entityToDto(tree);
    return treeResDto;
  }

  private Tree getTreeOrThrowException(Long id) throws Exception {
    Optional<Tree> tree = treeRepository.findById(id);
    if(tree.isEmpty()){
      throw new Exception();
    }
    return tree.get();
  }
}
