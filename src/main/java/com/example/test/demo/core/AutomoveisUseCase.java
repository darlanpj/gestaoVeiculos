package com.example.test.demo.core;

import com.example.test.demo.core.converter.mapper;
import com.example.test.demo.dataprovider.AutomoveisRepository;
import com.example.test.demo.dataprovider.entity.AutomovelEntity;
import com.example.test.demo.entrypoint.dto.AutomovelDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutomoveisUseCase {

    private final Logger log = LoggerFactory.getLogger(AutomoveisUseCase.class);
    private final AutomoveisRepository automoveisRepository;

    public AutomoveisUseCase(AutomoveisRepository automoveisRepository) {
        this.automoveisRepository = automoveisRepository;
    }


    public AutomovelEntity cadastraAutomovel(final AutomovelDTO automovel) {
        try {
            log.info("Cadastrando automovel");
            log.info("Automovel: {}", automovel.toString());
            AutomovelEntity automovelEntity = mapper.toEntity(automovel);
            log.info("AutomovelEntity: {}", automovelEntity.toString());
            return automoveisRepository.save(automovelEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar automovel");
        }
    }

    public List<AutomovelDTO> listaAutomveis() {
        try {
            log.info("Listando automoveis");
            List<AutomovelEntity> automovelEntityList = automoveisRepository.findAll();
            return automovelEntityList.stream()
                    .map(mapper::toDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar automoveis");
        }
    }

    public AutomovelDTO retornaAutomovelById(final Long id) {
        try {
            log.info("Obtendo automovel por id: {}", id);
            return mapper.toDomain(automoveisRepository.getReferenceById(id));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter automovel por" + id + " }");
        }
    }
}
