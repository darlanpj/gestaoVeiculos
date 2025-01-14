package com.example.test.demo.entrypoint;

import com.example.test.demo.core.AutomoveisUseCase;
import com.example.test.demo.entrypoint.dto.AutomovelDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GestaoAutomoveisControllerTest {

    @Mock
    private AutomoveisUseCase automoveisUseCase;

    @InjectMocks
    private GestaoAutomoveisController gestaoAutomoveisController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastroAutomoveis() {
        AutomovelDTO automovelDTO = new AutomovelDTO("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15));
        ResponseEntity responseEntity = gestaoAutomoveisController.cadastroAutomoveis(automovelDTO);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void testRetornaAutomoveis() {
        List<AutomovelDTO> automoveis = Arrays.asList(
                new AutomovelDTO("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15)),
                new AutomovelDTO("Toyota", "Corolla", new BigDecimal("80000.00"), LocalDate.of(2025, 1, 15))
        );
        when(automoveisUseCase.listaAutomveis()).thenReturn(automoveis);
        ResponseEntity<List<AutomovelDTO>> responseEntity = gestaoAutomoveisController.retornaAutomoveis();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(automoveis, responseEntity.getBody());
    }

    @Test
    void testRetornaAutomovelbyId() {
        AutomovelDTO automovelDTO = new AutomovelDTO("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15));
        when(automoveisUseCase.retornaAutomovelById(1L)).thenReturn(automovelDTO);
        ResponseEntity<AutomovelDTO> responseEntity = gestaoAutomoveisController.retornaAutomovelbyId(1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(automovelDTO, responseEntity.getBody());
    }
}
