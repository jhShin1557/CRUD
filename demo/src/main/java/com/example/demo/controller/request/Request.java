package com.example.demo.controller.request;

import com.example.demo.domain.Data;
import com.example.demo.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class Request {

    private final DataService dataService;
    @Autowired
    public Request(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/request")
    public String practice() {
        return "request/mapping";
    }
    @PostMapping("/requestParam")
//    public String requestParam(@RequestMapping("id") String id, @RequestMapping("text") String text
//    public String requestParam(@RequestMapping String id, @RequestMapping String text
    public String requestParam(String id, String text, Model model) {
        model.addAttribute("type", 1);
        model.addAttribute("id", id);
        model.addAttribute("text", text);
        return "request/data";
    }
    @PostMapping("/modelAttribute")
    public String modelAttribute(Data data, Model model) {
        model.addAttribute("type", 2);
        model.addAttribute("data", data);
        return "request/data";
    }

    @GetMapping("/pathVariable")
    public String pathVariable(Model model) {
        List<Data> dataList = dataService.getListData();
        model.addAttribute("dataList", dataList);
        return "request/pathVariable";
    }
    @GetMapping("/dataInfo/{num}")
    public String dataInfo(@PathVariable Integer num, Model model) {
        Data data = dataService.getDataInfo(num);
        model.addAttribute("data", data);
        return "request/dataInfo";
    }

    @GetMapping("/dataModify/{num}")
    public String dataModifyForm(@PathVariable Integer num, Model model) {
        Data data = dataService.getDataInfo(num);
        model.addAttribute("data", data);
        return "request/dataInfoModify";
    }

    @PostMapping("/dataModify")
    public String dataModify(Data data) {
        dataService.modifyDataInfo(data);
        return "redirect:/pathVariable";
    }

}
