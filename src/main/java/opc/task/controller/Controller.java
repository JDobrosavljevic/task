package opc.task.controller;

import opc.task.dto.ListaRezultataDTO;
import opc.task.service.KupacService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/controller")
public class Controller {
    @Resource
    KupacService kupacService;

    @GetMapping("/trazi")
    public ListaRezultataDTO trazi(){
        return kupacService.trazi();
    }

    @GetMapping("/akcija")
    public ListaRezultataDTO akcija(){
        return kupacService.akcija();
    }
}
