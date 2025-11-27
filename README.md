📘 Sistema de Cadastro – Projeto CRUD em Java
Este é um projeto simples desenvolvido para fins acadêmicos, com o objetivo de praticar Java, POO, manipulação de arquivos, estrutura de dados (fila e lista ligada) e Swing para interface gráfica.

Ele simula um pequeno sistema de gerenciamento contendo:

Disciplinas

Cursos

Professores

Inscrições

Cada entidade possui sua própria tela com operações CRUD (Criar, Buscar, Atualizar e Remover).

🧩 Funcionalidades Principais
✔️ CRUD completo
O sistema permite:

Cadastrar novos registros

Buscar registros existentes (com leitura via fila)

Atualizar dados

Remover registros

Reescrever arquivos sem linhas vazias (lista ligada simulada)

✔️ Manipulação de Arquivos
Todos os dados são salvos em arquivos .csv dentro da pasta:

C:/Users/SEU_USUARIO/Sistema Cadastro/
✔️ Regras importantes
Ao remover uma disciplina, todas as inscrições associadas também são excluídas.

As consultas são feitas a partir de filas construídas dinamicamente com os dados dos arquivos.

As remoções reescrevem todo o arquivo, garantindo que nenhuma linha vazia permaneça.

🖥️ Interfaces Disponíveis
O sistema possui abas independentes:

Disciplinas

Cursos

Professores

Inscrições

Cada aba contém campos de entrada, botões de ação e uma área de listagem.

🔧 Tecnologias Utilizadas
Java 17+

Java Swing (Interface gráfica)

Manipulação de Arquivos (.csv)

Estruturas de dados:

Filas

Listas encadeadas (simuladas ao reescrever arquivos)

MVC básico (Model – View – Controller)

📂 Estrutura do Projeto
/src
 ├── model
 │    ├── Disciplina.java
 │    ├── Curso.java
 │    ├── Professor.java
 │    └── Inscricao.java
 │
 ├── Controller
 │    ├── DisciplinaController.java
 │    ├── CursoController.java
 │    ├── ProfessorController.java
 │    └── InscricaoController.java
 │
 └── view
      └── Tela.java
▶️ Como Executar
Importe o projeto na sua IDE (Eclipse, IntelliJ, NetBeans, etc.)

Certifique‑se de que a pasta Sistema Cadastro será criada automaticamente pelo programa.

Execute a classe:

view/Tela.java
A interface abrirá com todas as abas funcionando.

📌 Observações
O projeto é simples, mas estruturado para demonstrar conceitos importantes de organização e modularização.

Perfeito para quem está começando em Java e precisa praticar lógica, arquivos e GUI.

🤝 Contribuições
Sugestões e melhorias são sempre bem‑vindas.
Fique à vontade para abrir issues ou pull requests.
