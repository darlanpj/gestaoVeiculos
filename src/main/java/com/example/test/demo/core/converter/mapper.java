package com.example.test.demo.core.converter;

import com.example.test.demo.dataprovider.entity.AutomovelEntity;
import com.example.test.demo.entrypoint.dto.AutomovelDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class mapper {

    public static AutomovelEntity toEntity(final AutomovelDTO automovel) {
        if (Optional.ofNullable(automovel)
                .isEmpty()) {
            return null;
        }
        AutomovelEntity automovelEntity = new AutomovelEntity();
        automovelEntity.setMarca(automovel.getMarca());
        automovelEntity.setModelo(automovel.getModelo());
        automovelEntity.setValor(automovel.getValor());
        automovelEntity.setDataCadastro(automovel.getDataCadastro());

        return automovelEntity;
    }

    public static AutomovelDTO toDomain(final AutomovelEntity entity) {

        if (Optional.ofNullable(entity)
                .isEmpty()) {
            return null;
        }

        AutomovelDTO automovelResponse = new AutomovelDTO();
        automovelResponse.setMarca(entity.getMarca());
        automovelResponse.setModelo(entity.getModelo());
        automovelResponse.setValor(entity.getValor());
        automovelResponse.setDataCadastro(entity.getDataCadastro());

        return automovelResponse;
    }
}
