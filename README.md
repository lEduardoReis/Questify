# 🚀 Questify - Sistema de Missões Gamificado

O **Questify** é um projeto em Java que transforma tarefas do dia a dia em missões, aplicando conceitos de gamificação como XP, níveis e recompensas.

Este projeto está sendo desenvolvido de forma incremental, acompanhando a evolução dos estudos em Java e backend.

---

## 🎯 Objetivo

Criar um sistema que torne atividades cotidianas mais motivadoras, simulando mecânicas de jogos como progressão de nível e recompensas.

---

## 🧠 Funcionalidades atuais

- ✅ Criação de missões via terminal
- ✅ Escolha de dificuldade:
    - Fácil
    - Média
    - Difícil
    - Épica
- ✅ Sistema de recompensa:
    - XP baseado na dificuldade
    - Moedas baseadas na dificuldade
- ✅ Sistema de níveis:
    - A cada 100 XP o usuário sobe de nível
- ✅ Controle de status da missão:
    - Pendente
    - Concluída
    - Cancelada
- ✅ Execução de múltiplas missões
- ✅ Refatoração com método reutilizável (`executarMissao`)

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
2. Missões são criadas via entrada do usuário
3. Usuário escolhe:
    - Concluir missão
    - Cancelar missão
4. Sistema aplica recompensas automaticamente
5. Resultado final é exibido no console

---

## 💡 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Enum
- Métodos reutilizáveis
- Separação de responsabilidades
- Refatoração de código
- Organização em camadas (inicial)

---

## 📈 Evolução do projeto

Este projeto está sendo desenvolvido de forma progressiva, acompanhando o aprendizado em Java.

Cada etapa adiciona novos conceitos e melhorias estruturais, simulando a evolução de um sistema real.

---

## 🚀 Próximos passos

- [ ] Menu interativo (loop)
- [ ] Validação de entradas
- [ ] Uso de coleções (`ArrayList`) para múltiplas missões
- [ ] Integração real entre Service e Repository
- [ ] Persistência de dados (arquivo ou banco)
- [ ] API REST com Spring Boot

---

## 👨‍💻 Autor

**Eduardo Gabriel Reis Farias**  
Estudante de desenvolvimento backend Java ☕

---

## 📌 Observação

Este projeto faz parte do processo de aprendizado em desenvolvimento backend, com foco em boas práticas, organização de código e evolução contínua.