package model;

public class CadastroPJ {

    private String razaoSocial;
    private String email;
    private String cpnj;
    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;
    private String numero;
    private String complemento;

    public CadastroPJ(String razaoSocial, String email, String cpnj, String cep, String logradouro, String localidade, String uf, String numero, String complemento) {
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.cpnj = cpnj;
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "CadastroPJ{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", email='" + email + '\'' +
                ", cpnj='" + cpnj + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
