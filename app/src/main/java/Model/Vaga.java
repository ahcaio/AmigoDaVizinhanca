package Model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "VAGA")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "ENDERECO", nullable = false)
    private String endereco;
    @Column(name = "TELEFONE", nullable = false)
    private String telefone;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;


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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Vaga" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'';
    }
}
