package es.unifacef.database2.service;

import es.unifacef.database2.model.Produto;
import es.unifacef.database2.repository.ProdutoRepository;
import org.hibernate.query.criteria.JpaConflictUpdateAction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ProdutoService {
    // essa classe vai usar o ProdutoRepository explorando a injeção de dependencia pelo construtor
    private ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }
    //recupera todos os produtos
    public List<Produto> listar() {
        return repo.findAll();
    }
    //recupera pelo id
    public Optional<Produto> /*Pode ou não retornar um produto*/ buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repo.save(produto); //retorna o produto inserido
    }

    public boolean deletarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Produto atualizar(Produto novo, Long id) {
        if (repo.existsById(id)) {
            novo.setId(id);
            return repo.save(novo);
        }
        return null;
    }


}
