package com.example.test.demo.core;

import com.example.test.demo.dataprovider.AutomoveisRepository;
import com.example.test.demo.dataprovider.entity.AutomovelEntity;
import com.example.test.demo.entrypoint.dto.AutomovelDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AutomoveisUseCaseTest {

    @Mock
    private AutomoveisRepository automoveisRepository;

    @InjectMocks
    private AutomoveisUseCase automoveisUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastroAutomovel() {
        AutomovelDTO automovelDTO = new AutomovelDTO("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15));
        AutomovelEntity automovelEntity = new AutomovelEntity("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15));
        when(automoveisRepository.save(automovelEntity)).thenReturn(automovelEntity);
        AutomovelEntity result = automoveisUseCase.cadastraAutomovel(automovelDTO);
        assertEquals(automovelEntity.getDataCadastro(), result.getDataCadastro());
        assertEquals(automovelEntity.getValor(), result.getValor());
    }

    @Test
    void testRetornaAutomovelById() {
        AutomovelEntity automovelEntity = new AutomovelEntity("Honda", "Civic", new BigDecimal("50000.00"), LocalDate.of(2025, 1, 15));
        when(automoveisRepository.getReferenceById(1L)).thenReturn(automovelEntity);
        AutomovelDTO result = automoveisUseCase.retornaAutomovelById(1L);
        assertEquals(new BigDecimal("50000.00"), result.getValor());
    }
}
