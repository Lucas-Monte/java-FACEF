package es.unifacef.database2.repository;

import es.unifacef.database2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    //A interface tera disponivel os seguintes metodos
    // findAll() -> select * from produto
    // findById(id) -> select * from produto where id= ...
    // save() -> insert into produto ou update produto set ...
    // deleteById(id) -> delete from produto where id= ...


}
