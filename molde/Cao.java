package molde;

public class Cao extends Animal {
    private String porte;
    private Boolean necessitaPasseio;

    public Cao(int id, String nome, int idade, String condicaoSaude, String temperamento, String porte, Boolean necessitaPasseio) {
        super(id, nome, "Cão", idade, condicaoSaude, temperamento);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }

    @Override
    void fazerSom() {
        System.out.println("Guau Guau");
    }

    public String getPorte() {
        return porte;
    }

    public Boolean getNecessitaPasseio() {
        return necessitaPasseio;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public void setNecessitaPasseio(Boolean necessitaPasseio) {
        this.necessitaPasseio = necessitaPasseio;
    }

    public void mostrarInfo() {
        System.out.println("Informações do Cão:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Espécie: " + getEspecie());
        System.out.println("Idade: " + getIdade() + " anos");
        System.out.println("Condição de Saúde: " + getCondicaoSaude());
        System.out.println("Temperamento: " + getTemperamento());
        System.out.println("Status: " + getStatus());
        System.out.println("Porte: " + porte);
        System.out.println("Necessita Passeio: " + (necessitaPasseio ? "Sim" : "Não"));
    }
}
