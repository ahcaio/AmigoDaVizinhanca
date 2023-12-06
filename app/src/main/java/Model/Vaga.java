package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Vaga {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "endereco")
    private String endereco;
    @ColumnInfo(name = "telefone")
    private String telefone;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "descricao")
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
        return "Vaga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
