package br.com.lorde.supremo.listavip;

import br.com.lorde.supremo.listavip.model.Convidado;
import br.com.lorde.supremo.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado> obterTodos(){
        return repository.findAll();
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);
    }
}
