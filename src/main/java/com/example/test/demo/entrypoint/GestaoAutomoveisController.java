package com.example.test.demo.entrypoint;

import com.example.test.demo.core.AutomoveisUseCase;
import com.example.test.demo.entrypoint.dto.AutomovelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/veiculos")
public class GestaoAutomoveisController {

    private final AutomoveisUseCase automoveisUseCase;

    public GestaoAutomoveisController(AutomoveisUseCase automoveisUseCase) {
        this.automoveisUseCase = automoveisUseCase;
    }

    @PostMapping(value = "/cadastroAutomoveis", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastroAutomoveis(@RequestBody final AutomovelDTO automovelRequest) {

        if (Objects.isNull(automovelRequest)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        automoveisUseCase.cadastraAutomovel(automovelRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/automoveis", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<AutomovelDTO>> retornaAutomoveis() {
        return new ResponseEntity<>(automoveisUseCase.listaAutomveis(), HttpStatus.OK);
    }

    @GetMapping(value = "/automovel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AutomovelDTO> retornaAutomovelbyId(@PathVariable final Long id) {
        return new ResponseEntity<>(automoveisUseCase.retornaAutomovelById(id), HttpStatus.OK);
    }

}
