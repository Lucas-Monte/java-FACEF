package es.unifacef.database2.controller;

import es.unifacef.database2.model.Produto;
import es.unifacef.database2.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id) {
        Optional<Produto> resposta = service.buscarPorId(id);
        if (!resposta.isEmpty()) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        //insere produto no banco
        Produto novo = service.salvar(produto);
        //Cria uma uri (uniform resource identifier) com o id do novo produto
        URI uri = URI.create("/produtos/" + novo.getId());
        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        if (service.deletarPorId(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto novo, @PathVariable Long id) {
        Produto resposta = service.atualizar(novo, id);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
