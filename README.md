# 🚀 Questify - Sistema de Missões Gamificado

O **Questify** é um projeto em Java que transforma tarefas do dia a dia em missões, aplicando conceitos de gamificação como XP, níveis e recompensas.

Este projeto está sendo desenvolvido de forma incremental, acompanhando a evolução dos estudos em Java e backend.

---

## 🎯 Objetivo

Criar um sistema que torne atividades cotidianas mais motivadoras, simulando mecânicas de jogos como progressão de nível e recompensas.

---

## 🧠 Funcionalidades atuais

## 🧠 Funcionalidades atuais

- ✅ Criação de missões
- ✅ Listagem de missões (formato amigável)
- ✅ Conclusão de missão com recompensa
- ✅ Cancelamento de missão
- ✅ Remoção de missão
- ✅ Busca de missão por ID
- ✅ Filtro de missões por status (pendente, concluída, cancelada)
- ✅ Sistema de XP e moedas
- ✅ Sistema de níveis automático
- ✅ Validação de ações (não permite concluir/cancelar missão inválida)
- ✅ Menu interativo com múltiplas operações


---

## 🏗️ Estrutura do projeto

```text
Questify
│
├── app
│   └── Main.java
│
├── model
│   ├── Usuario.java
│   └── Missao.java
│
├── enums
│   ├── Dificuldade.java
│   └── StatusMissao.java
│
├── repository
│   ├── MissaoRepository.java
│   └── UsuarioRepository.java
│
├── service
│   ├── MissaoService.java
│   └── UsuarioService.java
```

---

## 🧩 Arquitetura (em evolução)

O projeto segue uma organização inspirada em aplicações backend reais:

- **Model** → entidades e regras básicas
- **Enums** → valores fixos do sistema
- **Repository** → camada de acesso a dados (simulada)
- **Service** → regras de negócio (em evolução)
- **App** → entrada da aplicação (console)

> ⚠️ As camadas `service` e `repository` estão sendo preparadas para uso progressivo conforme o avanço dos estudos.

---

## 🔄 Fluxo atual da aplicação

1. Usuário é criado
2. Usuário cria missões (ficam pendentes)
3. Usuário pode:
   - visualizar status e missões
   - concluir uma missão específica
   - cancelar uma missão específica
4. Sistema atualiza XP, moedas e nível automaticamente
5. Loop continua até o usuário sair

---

## 💡 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Enum
- Métodos reutilizáveis
- Coleções (ArrayList)
- Manipulação de listas
- Menu interativo
- Métodos com retorno
- Separação de responsabilidades
- Refatoração de código
- Organização em camadas (inicial)

---

## 📈 Evolução do projeto

## 📈 Evolução do projeto

O projeto evoluiu de:

- execução simples de uma missão  
  ➡️ para
- sistema interativo com múltiplas missões  
  ➡️ com seleção dinâmica e manipulação de estado  
  ➡️ com operações completas de CRUD (Create, Read, Update, Delete)  
  ➡️ com filtro e busca de dados

Este projeto está sendo desenvolvido de forma progressiva, acompanhando o aprendizado em Java e simulando a evolução de um sistema real.

## 🚀 Próximos passos

- [ ] Implementar herança nas missões
- [ ] Aplicar polimorfismo (comportamentos diferentes por tipo de missão)
- [ ] Criar camada de Service (separar lógica do Main)
- [ ] Melhorar validação de entrada do usuário
- [ ] Contagem de missões por status
- [ ] Ordenação de missões
- [ ] Persistência de dados (arquivo ou banco)
- [ ] API REST com Spring Boot

---

## 👨‍💻 Autor

**Eduardo Gabriel Reis Farias**  
Estudante de desenvolvimento backend Java ☕

---

## 📌 Observação

Este projeto faz parte do processo de aprendizado em desenvolvimento backend, com foco em boas práticas, organização de código e evolução contínua.