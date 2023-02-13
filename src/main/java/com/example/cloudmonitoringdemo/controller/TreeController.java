package com.example.cloudmonitoringdemo.controller;


import com.example.cloudmonitoringdemo.dto.TreeReqDto;
import com.example.cloudmonitoringdemo.dto.TreeResDto;
import com.example.cloudmonitoringdemo.service.TreeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class TreeController {
  public static final String baseUrl = "/cm";

  @Autowired
  TreeService treeService;

  @GetMapping(baseUrl)
  public List<TreeResDto> getTree(){
    log.info("trying to get all data");
    return treeService.getTree();
  }

  @PostMapping(baseUrl+"/write")
  public TreeResDto postOrnament(@RequestBody TreeReqDto treeReqDto) throws Exception {
    log.info("trying to post data");
    return treeService.postOrnament(treeReqDto);
  }

  @PostMapping(baseUrl + "/update")
  public TreeResDto updateOrnament(@RequestBody TreeReqDto treeReqDto)
      throws Exception {
    log.info("trying to update data");
    return treeService.updateOrnament(treeReqDto);
  }

  @DeleteMapping(baseUrl + "/delete/{id}")
  public ResponseEntity<?> deleteOrnament(@RequestParam Long id, @RequestBody TreeReqDto treeReqDto) throws Exception {
    log.info("trying to delete only 1 data");
    return treeService.deleteOrnament(id, treeReqDto);
  }

  @GetMapping(baseUrl + "/ornament/{id}")
  public TreeResDto getOrnament(@PathVariable("id") Long id) throws Exception {
    log.info("trying to get only 1 data");
    return treeService.getOrnament(id);
  }

  @GetMapping(baseUrl + "/ping")
  public String getPingPong() throws Exception {
    log.info("test connection");
    return "pong";
  }

}
