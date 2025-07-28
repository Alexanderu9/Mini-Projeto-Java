package molde;

public abstract class Animal implements Validavel, Relatorio {
    private int id;
    private String nome;
    private String especie;
    private int idade;
    private String condicaoSaude;
    private String temperamento;
    private String status;

    public Animal(int id, String nome, String especie, int idade, String condicaoSaude, String temperamento) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.status = "Disponível"; 
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public int getIdade() {
        return idade;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    abstract void fazerSom();

    @Override
    public boolean validar() {
        return nome != null && !nome.trim().isEmpty() && 
               condicaoSaude != null && !condicaoSaude.trim().isEmpty() && 
               status != null && !status.trim().isEmpty();
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório do Animal:");
        System.out.println("Nome: " + getNome());
        System.out.println("Espécie: " + getEspecie());
        System.out.println("Idade: " + getIdade());
        System.out.println("Condição de Saúde: " + getCondicaoSaude());
        System.out.println("Status: " + getStatus());
        System.out.println("Temperamento: " + getTemperamento());
    }
}


