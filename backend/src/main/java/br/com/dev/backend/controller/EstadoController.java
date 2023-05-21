package br.com.dev.backend.controller;

import br.com.dev.backend.entity.Estado;
import br.com.dev.backend.service.EstadoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    // Buscar todos
    @GetMapping("/")
    public List<Estado> searchAll() {
        return estadoService.searchAll();
    }

    // Inserir
    @PostMapping("/")
    public Estado insert(@RequestBody Estado estado) {
        return estadoService.insert(estado);
    }

    // Alterar
    @PutMapping("/")
    public Estado alter(@RequestBody Estado estado) {
        return estadoService.alter(estado);
    }

    // Excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude(@PathVariable("id") Long id) {
        estadoService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
