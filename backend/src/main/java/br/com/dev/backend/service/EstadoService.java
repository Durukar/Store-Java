package br.com.dev.backend.service;

import br.com.dev.backend.entity.Estado;
import br.com.dev.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    // Buscar todos
    public List<Estado> searchAll(){
        return estadoRepository.findAll();
    }

    // Inserir
    public Estado insert(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    // Alterar
    public Estado alter(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    // Exclusão
    public void exclude(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }
}
