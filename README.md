#  Sistema de Gestão de Adoção de Animais

##  Sobre o Projeto

Este é um **mini projeto** desenvolvido em Java que simula um sistema de gestão para uma ONG dedicada à proteção animal. O sistema permite o gerenciamento completo de adotantes, animais e processos de adoção.

##  Funcionalidades

###  Gestão de Adotantes
-  Adicionar perfil de adotante
-  Editar informações do adotante
-  Habilitar/Desabilitar adotante
-  Listar todos os adotantes

###  Gestão de Animais
-  Adicionar cachorro
-  Adicionar gato
-  Remover animal
-  Alterar status do animal (Disponível/Indisponível)
-  Listar todos os animais

###  Gestão de Adoções
-  Gerar nova adoção
-  Realizar adoção (assinatura de termo)
-  Listar adoções (finalizadas e pendentes)

##  Tecnologias Utilizadas

- **Java SE** - Linguagem de programação
- **Scanner** - Entrada de dados do usuário
- **ArrayList** - Estrutura de dados para armazenamento
- **Programação Orientada a Objetos (POO)**

##  Conceitos de Java Aplicados

-  **Herança** - Classe `Animal` e suas especializações (`Cao`, `Gato`)
-  **Polimorfismo** - Método `fazerSom()` implementado diferentemente
-  **Encapsulamento** - Atributos privados com getters/setters
-  **Interfaces** - `Validavel` e `Relatorio`
-  **Classes Abstratas** - Classe `Animal`
-  **Tratamento de Exceções** - Try-catch para entradas inválidas
-  **Coleções** - ArrayList para gerenciar listas dinâmicas

##  Estrutura do Projeto

```
src/
├── Main.java              # Classe principal com interface do usuário
└── molde/
    ├── Animal.java         # Classe abstrata base
    ├── Cao.java           # Classe para cachorros
    ├── Gato.java          # Classe para gatos
    ├── Adotante.java      # Classe para pessoas adotantes
    ├── Adocao.java        # Classe para processos de adoção
    ├── Validavel.java     # Interface para validação
    └── Relatorio.java     # Interface para relatórios
```

##  Como Executar

1. **Clone o repositório**
   ```bash
   git clone [url-do-repositorio]
   ```

2. **Navegue até o diretório src**
   ```bash
   cd MiniProjeto/src
   ```

3. **Compile o projeto**
   ```bash
   javac Main.java
   ```

4. **Execute o programa**
   ```bash
   java Main
   ```

##  Como Usar

1. Execute o programa
2. Escolha uma das opções do menu principal:
   - **[1]** Gestão de Adotantes
   - **[2]** Gestão de Animais
   - **[3]** Gestão de Adoções
   - **[4]** Sair

3. Siga as instruções do submenu escolhido
4. Para adotar um animal:
   - Primeiro cadastre um adotante
   - Depois cadastre um animal
   - Vá em "Gestão de Adoções" → "Gerar Adoção"
   - Finalize com "Realizar Adoção"

##  Pré-requisitos

- Java 8 ou superior
- Terminal/Prompt de comando

##  Objetivo Educacional

Este projeto foi desenvolvido como exercício prático para demonstrar e aplicar conceitos fundamentais da programação orientada a objetos em Java, incluindo:

- Modelagem de classes e relacionamentos
- Implementação de interfaces e herança
- Manipulação de coleções
- Tratamento de exceções
- Desenvolvimento de aplicação console interativa

##  Licença

Este projeto é para fins educacionais e está disponível sob a licença MIT.

---

 **Desenvolvido como mini projeto de estudos em Java** 
