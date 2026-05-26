package es.unifacef.database2.controller;

import es.unifacef.database2.model.Produto;
import es.unifacef.database2.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    //Essa classe vai usar o ProdutoService explorando a injeção de dependencia do contrutor

    ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> resposta = service.listar();
        if (!resposta.isEmpty()) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id) {
        Optional<Produto> resposta = service.buscarPorId(id);
        if (!resposta.isEmpty()) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
