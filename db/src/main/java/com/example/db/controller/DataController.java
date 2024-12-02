package com.example.db.controller;

import com.example.db.dto.DataRequest;
import com.example.db.entity.Bqrm;
import com.example.db.service.BqrmService;
import com.example.db.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

//    private final DataService dataService;

    @Autowired
    private BqrmService bqrmService;

//    public DataController(DataService dataService) {
//        this.dataService = dataService;
//    }

//    @PostMapping("/save")
//    public ResponseEntity<String> saveData(@RequestBody DataRequest request) {
//        try {
//            String result = dataService.saveData(request);
//            return ResponseEntity.ok(result);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @GetMapping("/{name}")
    public ResponseEntity<Bqrm> getByName(@PathVariable String name) {
        return bqrmService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
