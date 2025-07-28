package molde;

public class Adotante implements Validavel, Relatorio {
    private String nome;
    private String cpf;
    private String endereco;
    private String preferencias;
    private boolean ativo;

    public Adotante(String nome, String cpf, String endereco, String preferencias) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.preferencias = preferencias;
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    @Override
    public boolean validar() {
        return nome != null && !nome.trim().isEmpty() && 
               cpf != null && !cpf.trim().isEmpty() && 
               endereco != null && !endereco.trim().isEmpty();
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório do Adotante:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Preferências: " + getPreferencias());
        System.out.println("Status: " + (isAtivo() ? "Ativo" : "Inativo"));
    }

    public void solicitarAdocao() {
        if (ativo) {
            System.out.println(nome + " pode solicitar adoção.");
        } else {
            System.out.println(nome + " está inativo e não pode solicitar adoção.");
        }
    }

}
