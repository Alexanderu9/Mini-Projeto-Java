
import java.util.ArrayList;
import java.util.Scanner;
import molde.Adocao;
import molde.Adotante;
import molde.Animal;
import molde.Cao;
import molde.Gato;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> Animales = new ArrayList<>();
        ArrayList<Adotante> Adotantes = new ArrayList<>();
        ArrayList<Adocao> Adocoes = new ArrayList<>();
        int proximoIdAnimal = 1;

        int opcao;

        do {
            System.out.println("==================================================");
            System.out.println("*** SISTEMA DA ONG DEDICADA Á PROTECÃO ANIMAL ***");
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("[1] Gestão de Adotantes");
            System.out.println("[2] Gestão de Animais");
            System.out.println("[3] Gestão de Adoções");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: Digite apenas números!");
                scanner.nextLine();
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    int opcaoAdotante;
                    do {
                        System.out.println("\n=== MENU DE GESTÃO DE ADOTANTES ===");
                        System.out.println("[1] Adicionar Perfil Adotante");
                        System.out.println("[2] Edição de Perfil Adotante");
                        System.out.println("[3] Desabilitar/Habilitar adotante");
                        System.out.println("[4] Listar Todos Adotantes");
                        System.out.println("[5] Voltar ao menu Principal");
                        System.out.print("Escolha uma opção: ");
                        try {
                            opcaoAdotante = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Erro: Digite apenas números!");
                            scanner.nextLine();
                            opcaoAdotante = -1;
                        }

                        switch (opcaoAdotante) {
                            case 1:
                                System.out.println("\n=== ADICIONAR PERFIL ADOTANTE ===");
                                try {
                                    System.out.print("Digite seu nome: ");
                                    String nome = scanner.nextLine().trim();
                                    if (nome.isEmpty()) {
                                        System.out.println("Erro: Nome não pode estar vazio!");
                                        break;
                                    }

                                    System.out.print("Digite o CPF: ");
                                    String cpf = scanner.nextLine().trim();
                                    if (cpf.isEmpty()) {
                                        System.out.println("Erro: CPF não pode estar vazio!");
                                        break;
                                    }

                                    System.out.print("Digite o endereço: ");
                                    String endereco = scanner.nextLine().trim();
                                    if (endereco.isEmpty()) {
                                        System.out.println("Erro: Endereço não pode estar vazio!");
                                        break;
                                    }

                                    System.out.print("Digite as preferências: ");
                                    String preferencias = scanner.nextLine().trim();

                                    Adotante novoAdotante = new Adotante(nome, cpf, endereco, preferencias);
                                    
                                    if (novoAdotante.validar()) {
                                        Adotantes.add(novoAdotante);
                                        System.out.println("Adotante adicionado com sucesso!");
                                    } else {
                                        System.out.println("Erro: Dados inválidos!");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro inesperado ao adicionar adotante: " + e.getMessage());
                                }
                                break;

                            case 2:
                                System.out.println("\n=== EDIÇÃO DE PERFIL ADOTANTE ===");
                                if (Adotantes.isEmpty()) {
                                    System.out.println("Nenhum adotante cadastrado.");
                                    break;
                                }
                                
                                System.out.println("Adotantes cadastrados:");
                                for (int i = 0; i < Adotantes.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " + Adotantes.get(i).getNome() + " - CPF: " + Adotantes.get(i).getCpf());
                                }
                                
                                System.out.print("Selecione o adotante para editar (número): ");
                                try {
                                    int indiceEditar = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceEditar >= 0 && indiceEditar < Adotantes.size()) {
                                        Adotante adotanteEditar = Adotantes.get(indiceEditar);
                                        
                                        System.out.println("\nO que deseja editar?");
                                        System.out.println("[1] Nome");
                                        System.out.println("[2] Endereço");
                                        System.out.println("[3] Preferências");
                                        System.out.print("Escolha uma opção: ");
                                        try {
                                            int opcaoEdicao = scanner.nextInt();
                                            scanner.nextLine();
                                            
                                            switch (opcaoEdicao) {
                                                case 1:
                                                    System.out.print("Digite o novo nome: ");
                                                    String novoNome = scanner.nextLine().trim();
                                                    if (!novoNome.isEmpty()) {
                                                        adotanteEditar.setNome(novoNome);
                                                        System.out.println("Nome atualizado com sucesso!");
                                                    } else {
                                                        System.out.println("Nome não pode estar vazio!");
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.print("Digite o novo endereço: ");
                                                    String novoEndereco = scanner.nextLine().trim();
                                                    if (!novoEndereco.isEmpty()) {
                                                        adotanteEditar.setEndereco(novoEndereco);
                                                        System.out.println("Endereço atualizado com sucesso!");
                                                    } else {
                                                        System.out.println("Endereço não pode estar vazio!");
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.print("Digite as novas preferências: ");
                                                    String novasPreferencias = scanner.nextLine().trim();
                                                    adotanteEditar.setPreferencias(novasPreferencias);
                                                    System.out.println("Preferências atualizadas com sucesso!");
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Erro: Digite apenas números para as opções!");
                                            scanner.nextLine();
                                        }
                                    } else {
                                        System.out.println("Adotante não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar o adotante!");
                                    scanner.nextLine();
                                }
                                break;
                                
                            case 3:
                                System.out.println("\n=== HABILITAR/DESABILITAR ADOTANTE ===");
                                if (Adotantes.isEmpty()) {
                                    System.out.println("Nenhum adotante cadastrado.");
                                    break;
                                }
                                
                                System.out.println("Adotantes cadastrados:");
                                for (int i = 0; i < Adotantes.size(); i++) {
                                    Adotante adotante = Adotantes.get(i);
                                    String status = adotante.isAtivo() ? "Ativo" : "Inativo";
                                    System.out.println("[" + (i + 1) + "] " + adotante.getNome() + " - CPF: " + adotante.getCpf() + " - Status: " + status);
                                }
                                
                                System.out.print("Selecione o adotante para alterar status (número): ");
                                try {
                                    int indiceStatus = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceStatus >= 0 && indiceStatus < Adotantes.size()) {
                                        Adotante adotanteStatus = Adotantes.get(indiceStatus);
                                        adotanteStatus.setAtivo(!adotanteStatus.isAtivo());
                                        String novoStatus = adotanteStatus.isAtivo() ? "habilitado" : "desabilitado";
                                        System.out.println("Adotante " + novoStatus + " com sucesso!");
                                    } else {
                                        System.out.println("Adotante não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar o adotante!");
                                    scanner.nextLine();
                                }
                                break;
                                
                            case 4:
                                System.out.println("\n=== LISTA DE TODOS OS ADOTANTES ===");
                                if (Adotantes.isEmpty()) {
                                    System.out.println("Nenhum adotante cadastrado.");
                                } else {
                                    System.out.println("Total de adotantes: " + Adotantes.size());
                                    System.out.println("==========================================");
                                    for (int i = 0; i < Adotantes.size(); i++) {
                                        System.out.println("\nAdotante #" + (i + 1));
                                        Adotantes.get(i).gerarRelatorio();
                                        System.out.println("==========================================");
                                    }
                                }
                                break;
                                
                            case 5:
                                System.out.println("Voltando ao menu principal...");
                                break;
                        }

                    } while (opcaoAdotante !=5);
                    break;
                case 2:
                    int opcaoAnimal;
                    do {
                        System.out.println("\n=== MENU DE GESTÃO DE ANIMAIS ===");
                        System.out.println("[1] Adicionar Cachorro");
                        System.out.println("[2] Adicionar Gato");
                        System.out.println("[3] Remover Animal");
                        System.out.println("[4] Desabilitar/Habilitar Animal");
                        System.out.println("[5] Listar Todos Animais");
                        System.out.println("[6] Voltar ao menu Principal");
                        System.out.print("Escolha uma opção: ");
                        try {
                            opcaoAnimal = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Erro: Digite apenas números!");
                            scanner.nextLine();
                            opcaoAnimal = -1;
                        }

                        switch (opcaoAnimal) {
                            case 1:
                                System.out.println("\n=== ADICIONAR CACHORRO ===");
                                try {
                                    System.out.print("Digite o nome do cachorro: ");
                                    String nomeCao = scanner.nextLine().trim();
                                    if (nomeCao.isEmpty()) {
                                        System.out.println("Erro: Nome não pode estar vazio!");
                                        break;
                                    }

                                    System.out.print("Digite a idade: ");
                                    int idadeCao;
                                    try {
                                        idadeCao = scanner.nextInt();
                                        if (idadeCao < 0) {
                                            System.out.println("Erro: Idade não pode ser negativa!");
                                            scanner.nextLine();
                                            break;
                                        }
                                        scanner.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro: Digite apenas números para a idade!");
                                        scanner.nextLine();
                                        break;
                                    }

                                    System.out.print("Digite a condição de saúde: ");
                                    String condicaoSaudeCao = scanner.nextLine().trim();
                                    if (condicaoSaudeCao.isEmpty()) {
                                        System.out.println("Erro: Condição de saúde não pode estar vazia!");
                                        break;
                                    }

                                    System.out.print("Digite o temperamento: ");
                                    String temperamentoCao = scanner.nextLine().trim();

                                    System.out.print("Digite o porte (Pequeno/Médio/Grande): ");
                                    String porte = scanner.nextLine().trim();

                                    System.out.print("Necessita passeio? (true/false): ");
                                    Boolean necessitaPasseio;
                                    try {
                                        necessitaPasseio = scanner.nextBoolean();
                                        scanner.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro: Digite 'true' ou 'false' para necessita passeio!");
                                        scanner.nextLine();
                                        break;
                                    }

                                    Cao novoCao = new Cao(proximoIdAnimal++, nomeCao, idadeCao, condicaoSaudeCao, temperamentoCao, porte, necessitaPasseio);
                                    
                                    if (novoCao.validar()) {
                                        Animales.add(novoCao);
                                        System.out.println("Cachorro adicionado com sucesso!");
                                    } else {
                                        System.out.println("Erro: Dados inválidos!");
                                        proximoIdAnimal--; 
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro inesperado ao adicionar cachorro: " + e.getMessage());
                                    proximoIdAnimal--;
                                }
                                break;

                            case 2:
                                System.out.println("\n=== ADICIONAR GATO ===");
                                try {
                                    System.out.print("Digite o nome do gato: ");
                                    String nomeGato = scanner.nextLine().trim();
                                    if (nomeGato.isEmpty()) {
                                        System.out.println("Erro: Nome não pode estar vazio!");
                                        break;
                                    }

                                    System.out.print("Digite a idade: ");
                                    int idadeGato;
                                    try {
                                        idadeGato = scanner.nextInt();
                                        if (idadeGato < 0) {
                                            System.out.println("Erro: Idade não pode ser negativa!");
                                            scanner.nextLine();
                                            break;
                                        }
                                        scanner.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro: Digite apenas números para a idade!");
                                        scanner.nextLine();
                                        break;
                                    }

                                    System.out.print("Digite a condição de saúde: ");
                                    String condicaoSaudeGato = scanner.nextLine().trim();
                                    if (condicaoSaudeGato.isEmpty()) {
                                        System.out.println("Erro: Condição de saúde não pode estar vazia!");
                                        break;
                                    }

                                    System.out.print("Digite o temperamento: ");
                                    String temperamentoGato = scanner.nextLine().trim();

                                    System.out.print("Convive com outros gatos? (true/false): ");
                                    Boolean conviveComOutrosGatos;
                                    try {
                                        conviveComOutrosGatos = scanner.nextBoolean();
                                        scanner.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro: Digite 'true' ou 'false' para convivência!");
                                        scanner.nextLine();
                                        break;
                                    }

                                    Gato novoGato = new Gato(proximoIdAnimal++, nomeGato, idadeGato, condicaoSaudeGato, temperamentoGato, conviveComOutrosGatos);
                                    
                                    if (novoGato.validar()) {
                                        Animales.add(novoGato);
                                        System.out.println("Gato adicionado com sucesso!");
                                    } else {
                                        System.out.println("Erro: Dados inválidos!");
                                        proximoIdAnimal--;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro inesperado ao adicionar gato: " + e.getMessage());
                                    proximoIdAnimal--;
                                }
                                break;

                            case 3:
                                System.out.println("\n=== REMOVER ANIMAL ===");
                                if (Animales.isEmpty()) {
                                    System.out.println("Nenhum animal cadastrado.");
                                    break;
                                }
                                
                                System.out.println("Animais cadastrados:");
                                for (int i = 0; i < Animales.size(); i++) {
                                    Animal animal = Animales.get(i);
                                    System.out.println("[" + (i + 1) + "] " + animal.getNome() + " - " + animal.getEspecie() + " (ID: " + animal.getId() + ")");
                                }
                                
                                System.out.print("Selecione o animal para remover (número): ");
                                try {
                                    int indiceRemover = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceRemover >= 0 && indiceRemover < Animales.size()) {
                                        Animal animalParaRemover = Animales.get(indiceRemover);
                                        
                                        boolean temAdocaoPendente = false;
                                        for (Adocao adocao : Adocoes) {
                                            if (adocao.getAnimalAdotado().getId() == animalParaRemover.getId() && 
                                                !adocao.getTermoAssinado()) {
                                                temAdocaoPendente = true;
                                                break;
                                            }
                                        }
                                        
                                        if (temAdocaoPendente) {
                                            System.out.println("Não é possível remover: animal possui adoção pendente!");
                                        } else {
                                            Animal animalRemovido = Animales.remove(indiceRemover);
                                            System.out.println("Animal " + animalRemovido.getNome() + " removido com sucesso!");
                                        }
                                    } else {
                                        System.out.println("Animal não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar o animal!");
                                    scanner.nextLine();
                                }
                                break;

                            case 4:
                                System.out.println("\n=== HABILITAR/DESABILITAR ANIMAL ===");
                                if (Animales.isEmpty()) {
                                    System.out.println("Nenhum animal cadastrado.");
                                    break;
                                }
                                
                                System.out.println("Animais cadastrados:");
                                for (int i = 0; i < Animales.size(); i++) {
                                    Animal animal = Animales.get(i);
                                    System.out.println("[" + (i + 1) + "] " + animal.getNome() + " - " + animal.getEspecie() + " - Status: " + animal.getStatus());
                                }
                                
                                System.out.print("Selecione o animal para alterar status (número): ");
                                try {
                                    int indiceStatus = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceStatus >= 0 && indiceStatus < Animales.size()) {
                                        Animal animalStatus = Animales.get(indiceStatus);
                                        String novoStatus = animalStatus.getStatus().equals("Disponível") ? "Indisponível" : "Disponível";
                                        animalStatus.setStatus(novoStatus);
                                        System.out.println("Status do animal " + animalStatus.getNome() + " alterado para: " + novoStatus);
                                    } else {
                                        System.out.println("Animal não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar o animal!");
                                    scanner.nextLine();
                                }
                                break;

                            case 5:
                                System.out.println("\n=== LISTA DE TODOS OS ANIMAIS ===");
                                if (Animales.isEmpty()) {
                                    System.out.println("Nenhum animal cadastrado.");
                                } else {
                                    int totalCachorros = 0;
                                    int totalGatos = 0;
                                    
                                
                                    for (Animal animal : Animales) {
                                        if (animal instanceof Cao) {
                                            totalCachorros++;
                                        } else if (animal instanceof Gato) {
                                            totalGatos++;
                                        }
                                    }
                                    
                                    System.out.println("Total de animais: " + Animales.size());
                                    System.out.println("Cachorros: " + totalCachorros + " | Gatos: " + totalGatos);
                                    System.out.println("==========================================");
                                    
                                    System.out.println("\n CACHORROS: ");
                                    for (int i = 0; i < Animales.size(); i++) {
                                        Animal animal = Animales.get(i);
                                        if (animal instanceof Cao) {
                                            System.out.println("\nCachorro #" + animal.getId());
                                            ((Cao) animal).mostrarInfo();
                                            System.out.println("--------------------");
                                        }
                                    }
                                    
                                    
                                    System.out.println("\n GATOS: ");
                                    for (int i = 0; i < Animales.size(); i++) {
                                        Animal animal = Animales.get(i);
                                        if (animal instanceof Gato) {
                                            System.out.println("\nGato #" + animal.getId());
                                            ((Gato) animal).mostrarInfo();
                                            System.out.println("--------------------");
                                        }
                                    }
                                }
                                break;

                            case 6:
                                System.out.println("Voltando ao menu principal...");
                                break;
                                
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                    } while (opcaoAnimal != 6);
                    break;
                case 3:
                    int opcaoAdocao;
                    do {
                        System.out.println("\n=== MENU DE GESTÃO DE ADOÇÕES ===");
                        System.out.println("[1] Gerar Adoção");
                        System.out.println("[2] Realizar Adoção");
                        System.out.println("[3] Listar Adoções");
                        System.out.println("[4] Voltar ao menu Principal");
                        System.out.print("Escolha uma opção: ");
                        try {
                            opcaoAdocao = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Erro: Digite apenas números!");
                            scanner.nextLine();
                            opcaoAdocao = -1;
                        }

                        switch (opcaoAdocao) {
                            case 1:
                                System.out.println("\n=== GERAR ADOÇÃO ===");
                                
                                ArrayList<Adotante> adotantesAtivos = new ArrayList<>();
                                for (Adotante adotante : Adotantes) {
                                    if (adotante.isAtivo()) {
                                        adotantesAtivos.add(adotante);
                                    }
                                }
                                
                                if (adotantesAtivos.isEmpty()) {
                                    System.out.println("Nenhum adotante ativo disponível.");
                                    break;
                                }
                                
                                ArrayList<Animal> animaisDisponiveis = new ArrayList<>();
                                for (Animal animal : Animales) {
                                    if (animal.getStatus().equals("Disponível")) {
                                        animaisDisponiveis.add(animal);
                                    }
                                }
                                
                                if (animaisDisponiveis.isEmpty()) {
                                    System.out.println("Nenhum animal disponível para adoção.");
                                    break;
                                }
                                
                                System.out.println("\nAdotantes ativos:");
                                for (int i = 0; i < adotantesAtivos.size(); i++) {
                                    Adotante adotante = adotantesAtivos.get(i);
                                    System.out.println("[" + (i + 1) + "] " + adotante.getNome() + " - CPF: " + adotante.getCpf());
                                }
                                
                                System.out.print("Selecione o adotante (número): ");
                                try {
                                    int indiceAdotante = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceAdotante < 0 || indiceAdotante >= adotantesAtivos.size()) {
                                        System.out.println("Adotante não encontrado.");
                                        break;
                                    }
                                    
                                    Adotante adotanteSelecionado = adotantesAtivos.get(indiceAdotante);
                                    
                                    System.out.println("\nAnimais disponíveis:");
                                    for (int i = 0; i < animaisDisponiveis.size(); i++) {
                                        Animal animal = animaisDisponiveis.get(i);
                                        System.out.println("[" + (i + 1) + "] " + animal.getNome() + " - " + animal.getEspecie() + " (ID: " + animal.getId() + ")");
                                    }
                                    
                                    System.out.print("Selecione o animal (número): ");
                                    try {
                                        int indiceAnimal = scanner.nextInt() - 1;
                                        scanner.nextLine();
                                        
                                        if (indiceAnimal < 0 || indiceAnimal >= animaisDisponiveis.size()) {
                                            System.out.println("Animal não encontrado.");
                                            break;
                                        }
                                        
                                        Animal animalSelecionado = animaisDisponiveis.get(indiceAnimal);
                                        
                                        Adocao novaAdocao = new Adocao(adotanteSelecionado, animalSelecionado, false);
                                        Adocoes.add(novaAdocao);
                                        
                                        animalSelecionado.setStatus("Adotado");
                                        
                                        System.out.println("Adoção gerada com sucesso!");
                                        System.out.println("Adotante: " + adotanteSelecionado.getNome());
                                        System.out.println("Animal: " + animalSelecionado.getNome());
                                        System.out.println("Status: Aguardando assinatura do termo");
                                    } catch (Exception e) {
                                        System.out.println("Erro: Digite apenas números para selecionar o animal!");
                                        scanner.nextLine();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar o adotante!");
                                    scanner.nextLine();
                                }
                                break;

                            case 2:
                                System.out.println("\n=== REALIZAR ADOÇÃO ===");
                                if (Adocoes.isEmpty()) {
                                    System.out.println("Nenhuma adoção pendente.");
                                    break;
                                }
                                
                                ArrayList<Adocao> adocoesPendentes = new ArrayList<>();
                                for (Adocao adocao : Adocoes) {
                                    if (!adocao.getTermoAssinado()) {
                                        adocoesPendentes.add(adocao);
                                    }
                                }
                                
                                if (adocoesPendentes.isEmpty()) {
                                    System.out.println("Nenhuma adoção pendente de assinatura.");
                                    break;
                                }
                                
                                System.out.println("Adoções pendentes:");
                                for (int i = 0; i < adocoesPendentes.size(); i++) {
                                    Adocao adocao = adocoesPendentes.get(i);
                                    System.out.println("[" + (i + 1) + "] " + adocao.getAdotante().getNome() + 
                                                     " → " + adocao.getAnimalAdotado().getNome() + 
                                                     " (" + adocao.getAnimalAdotado().getEspecie() + ")");
                                }
                                
                                System.out.print("Selecione a adoção para finalizar (número): ");
                                try {
                                    int indiceAdocao = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    
                                    if (indiceAdocao >= 0 && indiceAdocao < adocoesPendentes.size()) {
                                        Adocao adocaoFinalizar = adocoesPendentes.get(indiceAdocao);
                                        adocaoFinalizar.setTermoAssinado(true);
                                        
                                        System.out.println("Adoção realizada com sucesso!");
                                        System.out.println("Termo assinado para:");
                                        System.out.println("Adotante: " + adocaoFinalizar.getAdotante().getNome());
                                        System.out.println("Animal: " + adocaoFinalizar.getAnimalAdotado().getNome());
                                    } else {
                                        System.out.println("Adoção não encontrada.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: Digite apenas números para selecionar a adoção!");
                                    scanner.nextLine();
                                }
                                break;

                            case 3:
                                System.out.println("\n=== LISTA DE ADOÇÕES ===");
                                if (Adocoes.isEmpty()) {
                                    System.out.println("Nenhuma adoção registrada.");
                                } else {
                                    int contadorPendentes = 0;
                                    int adocoesFinalizadas = 0;
                                    
                                    for (Adocao adocao : Adocoes) {
                                        if (adocao.getTermoAssinado()) {
                                            adocoesFinalizadas++;
                                        } else {
                                            contadorPendentes++;
                                        }
                                    }
                                    
                                    System.out.println("ESTATÍSTICAS:");
                                    System.out.println("Total de adoções: " + Adocoes.size());
                                    System.out.println("Finalizadas: " + adocoesFinalizadas + " | Pendentes: " + contadorPendentes);
                                    System.out.println("==========================================");
                                    
                                    if (adocoesFinalizadas > 0) {
                                        System.out.println("\nADOÇÕES FINALIZADAS:");
                                        int contador = 1;
                                        for (Adocao adocao : Adocoes) {
                                            if (adocao.getTermoAssinado()) {
                                                System.out.println("\nAdoção #" + contador++);
                                                System.out.println("Adotante: " + adocao.getAdotante().getNome() + " (CPF: " + adocao.getAdotante().getCpf() + ")");
                                                System.out.println("Animal: " + adocao.getAnimalAdotado().getNome() + " - " + adocao.getAnimalAdotado().getEspecie());
                                                System.out.println("Status: Termo Assinado");
                                                System.out.println("--------------------");
                                            }
                                        }
                                    }
                                    
                                    if (contadorPendentes > 0) {
                                        System.out.println("\nADOÇÕES PENDENTES:");
                                        int contador = 1;
                                        for (Adocao adocao : Adocoes) {
                                            if (!adocao.getTermoAssinado()) {
                                                System.out.println("\nAdoção #" + contador++);
                                                System.out.println("Adotante: " + adocao.getAdotante().getNome() + " (CPF: " + adocao.getAdotante().getCpf() + ")");
                                                System.out.println("Animal: " + adocao.getAnimalAdotado().getNome() + " - " + adocao.getAnimalAdotado().getEspecie());
                                                System.out.println("Status: Aguardando Assinatura");
                                                System.out.println("--------------------");
                                            }
                                        }
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Voltando ao menu principal...");
                                break;
                                
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                    } while (opcaoAdocao != 4);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

}
