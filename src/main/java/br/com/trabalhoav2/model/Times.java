package br.com.trabalhoav2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Times implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idTimes;
    private String nome;
    private int pontos;
    private String localizacao;

    public long getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(long idTimes) {
        this.idTimes = idTimes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
   