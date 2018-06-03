ARCHITECTURE DESIGN

Design Patterns:
  Numa altura inicial do projeto previmos a ulilização de um singleton para a comunicação de objetos json entre o servidor e o utilizador. Esta previsão foi feita com base num modelo de Rest Api em php, no entanto, optámos por fazê-lo em java pelo que este DP ainda está questionável (pela falta de experiência no tema). 


TEST DESIGN

- Criação de objetos de classes é feita corretamente através de dados da base de dados.
- Alterações na base de dados são feitas com sucesso
- Input inválido do utilizador gera erros
- Registos condicionais (por exemplo, não aceitar registos com campos obrigatórios em branco)
- Sign up de contas já existentes não é válido
- Criaçâo de eventos/discotecas já existentes não é válido
- Criação de novos elementos com valores válidos não entra em colisão com dados já existentes (geração de id's únicos automaticamente)


MAQUINA DE ESTADOS SIMPLES:
![Upgrade](https://github.com/PedroMiguelSilva/Nite/blob/master/upgrade.png)


UML:
![UML](https://github.com/PedroMiguelSilva/Nite/blob/master/ClassDiagram.PNG)


![StateMachine1](https://github.com/PedroMiguelSilva/Nite/blob/master/FInal.png)
