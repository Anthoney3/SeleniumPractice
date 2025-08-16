package com.selenium.practice.seleniumpractice.controller;

import com.selenium.practice.seleniumpractice.models.CreepyPastaElement;
import com.selenium.practice.seleniumpractice.service.SearchSteps;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/creepypasta")
@RequiredArgsConstructor
public class CreepyPastaController {

    final SearchSteps searchSteps;

    @GetMapping("/latest")
    public ResponseEntity<List<CreepyPastaElement>> getLatestCreepyPastas() throws IOException {
        return ResponseEntity.ok(searchSteps.search());
    }
}
