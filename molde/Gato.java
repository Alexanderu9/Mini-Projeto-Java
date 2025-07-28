package molde;

public class Gato extends Animal {
    private Boolean conviveComOutrosGatos;

    public Gato(int id, String nome, int idade, String condicaoSaude, String temperamento, Boolean conviveComOutrosGatos) {
        super(id, nome, "Gato", idade, condicaoSaude, temperamento);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    @Override
    void fazerSom() {
        System.out.println("Miau");
    }

    public Boolean getConviveComOutrosGatos() {
        return conviveComOutrosGatos;
    }

    public void setConviveComOutrosGatos(Boolean conviveComOutrosGatos) {
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    public void mostrarInfo() {
        System.out.println("Informações do Gato:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Espécie: " + getEspecie());
        System.out.println("Idade: " + getIdade() + " anos");
        System.out.println("Condição de Saúde: " + getCondicaoSaude());
        System.out.println("Temperamento: " + getTemperamento());
        System.out.println("Status: " + getStatus());
        System.out.println("Convive com outros gatos: " + (conviveComOutrosGatos ? "Sim" : "Não"));
    }
}
