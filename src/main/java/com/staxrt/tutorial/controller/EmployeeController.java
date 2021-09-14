
package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.Output1Int;
import com.staxrt.tutorial.model.Output2Int;
import com.staxrt.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;


  @GetMapping("/count/{gender}")
  public ResponseEntity<List<Output2Int>> getCountByGender(@PathVariable(value = "gender") String gender)
      throws ResourceNotFoundException {
    List<Output2Int> list = employeeRepository.findCountByGender(gender);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/minmax/{deptname}")
  public ResponseEntity<List<Output1Int>> getMinMaxByDept(@PathVariable(value = "deptname") String deptname)
          throws ResourceNotFoundException {
    List<Output1Int> list = employeeRepository.findMinMaxByDept(deptname);
    return ResponseEntity.ok().body(list);
  }

}
