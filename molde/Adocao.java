package molde;

public class Adocao implements Relatorio {
    private Adotante adotante;
    private Animal animalAdotado;
    private Boolean termoAssinado;

    public Adocao(Adotante adotante, Animal animalAdotado, Boolean termoAssinado) {
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.termoAssinado = termoAssinado;
    }

    public void registrarAdocao() {
        if (termoAssinado) {
            System.out.println("Adoção registrada com sucesso!");
            System.out.println("Adotante: " + adotante.getNome() + " (CPF: " + adotante.getCpf() + ")");
            System.out.println("Animal: " + animalAdotado.getNome() + " - " + animalAdotado.getEspecie());
        } else {
            System.out.println("Não foi possível registrar a adoção. Termo não assinado.");
        }
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Animal getAnimalAdotado() {
        return animalAdotado;
    }

    public void setAnimalAdotado(Animal animalAdotado) {
        this.animalAdotado = animalAdotado;
    }

    public Boolean getTermoAssinado() {
        return termoAssinado;
    }

    public void setTermoAssinado(Boolean termoAssinado) {
        this.termoAssinado = termoAssinado;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório da Adoção:");
        System.out.println("Adotante: " + adotante.getNome() + " (CPF: " + adotante.getCpf() + ")");
        System.out.println("Animal: " + animalAdotado.getNome() + " - " + animalAdotado.getEspecie());
        System.out.println("Termo Assinado: " + (termoAssinado ? "Sim" : "Não"));
        System.out.println("Status: " + (termoAssinado ? "Adoção Finalizada" : "Aguardando Assinatura"));
    }
}