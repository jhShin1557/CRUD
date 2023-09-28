package com.example.demo.controller.json;

import com.example.demo.domain.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class JsonController {


    @GetMapping("/jsonExample")
    public String practice() {
        return "json/json";
    }

    @PostMapping("/sendText")
    @ResponseBody
    public String receiveText(@RequestBody String text) {
        return text;
    }

    @PostMapping("/sendJson1")
    @ResponseBody
    public Data receiveJson(@RequestBody Data data) {
        return data;
    }
}
