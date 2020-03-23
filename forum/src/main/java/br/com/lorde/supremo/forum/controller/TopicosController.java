package br.com.lorde.supremo.forum.controller;

import br.com.lorde.supremo.forum.controller.dto.DetalhesTopicoDto;
import br.com.lorde.supremo.forum.controller.dto.TopicoDto;
import br.com.lorde.supremo.forum.form.TopicoForm;
import br.com.lorde.supremo.forum.model.Topico;
import br.com.lorde.supremo.forum.repository.CursoRepository;
import br.com.lorde.supremo.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    @Cacheable(value = "listaTopicos")
    public Page<TopicoDto> lista(@RequestParam(required = false) String curso, Pageable paginate){
        if(curso != null){
            Page<Topico> topicos = repository.findByCursoNome(curso, paginate);
            return TopicoDto.convert(topicos);
        }
        Page<Topico> topicos = repository.findAll(paginate);
        return TopicoDto.convert(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id){
        Optional<Topico> topico = repository.findById(id);
        if(!topico.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalhesTopicoDto(topico.get()));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.convert(cursoRepository);
        repository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoForm form){
        Optional<Topico> opTopico = repository.findById(id);
        if(!opTopico.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Topico topico = opTopico.get();
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());

        return ResponseEntity.ok().body(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaTopicos", allEntries = true)
    public ResponseEntity remover(@PathVariable Long id){
        Optional<Topico> opTopico = repository.findById(id);
        if(!opTopico.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return  ResponseEntity.ok().body("Exclusão de tópico efetuada com sucesso!");
    }
}
