package br.com.lorde.supremo.listavip.repository;

import br.com.lorde.supremo.listavip.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
//}

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {
}
