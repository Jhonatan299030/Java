package br.com.lorde.supremo.listavip.model;

import org.springframework.util.MultiValueMap;

import javax.persistence.*;

@Entity(name="convidado")
public class Convidado {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Convidado() {
    }

    public Convidado(String nome, String email, String telefone) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Convidado(MultiValueMap convidado){
        super();
        this.nome = (String) convidado.getFirst("nome");
        this.email = (String) convidado.getFirst("email");
        this.telefone = (String) convidado.getFirst("telefone");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
