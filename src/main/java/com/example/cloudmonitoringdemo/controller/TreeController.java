package com.example.cloudmonitoringdemo.controller;


import com.example.cloudmonitoringdemo.dto.TreeReqDto;
import com.example.cloudmonitoringdemo.dto.TreeResDto;
import com.example.cloudmonitoringdemo.service.TreeService;
import java.util.List;
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

@RestController
public class TreeController {
  public static final String baseUrl = "/cm";

  @Autowired
  TreeService treeService;

  @GetMapping(baseUrl)
  public List<TreeResDto> getTree(){
    return treeService.getTree();
  }

  @GetMapping(baseUrl+"/write")
  public ModelAndView getPostOrnament() throws Exception {
    ModelAndView mv = new ModelAndView("tree/write");
    return mv;
  }

  @PostMapping(baseUrl+"/write")
  public TreeResDto postOrnament(@RequestBody TreeReqDto treeReqDto) throws Exception {
    return treeService.postOrnament(treeReqDto);
  }

  @GetMapping(baseUrl + "/update")
  public TreeResDto getUpdateOrnament(@RequestParam("id") Long id)
      throws Exception {
    return treeService.getOrnament(id);
  }

  @PostMapping(baseUrl + "/update")
  public TreeResDto updateOrnament(@RequestBody TreeReqDto treeReqDto)
      throws Exception {
    return treeService.updateOrnament(treeReqDto);
  }

  @DeleteMapping(baseUrl + "/delete/{id}")
  public ResponseEntity<?> deleteOrnament(@RequestParam Long id, @RequestBody TreeReqDto treeReqDto) throws Exception {
    return treeService.deleteOrnament(id, treeReqDto);
  }

  @GetMapping(baseUrl + "/ornament/{id}")
  public TreeResDto getOrnament(@PathVariable("id") Long id) throws Exception {
    return treeService.getOrnament(id);
  }

  @GetMapping(baseUrl + "/ping")
  public String getPingPong() throws Exception {
    return "pong";
  }

}
