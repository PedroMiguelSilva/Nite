SETUP/INSTALATION
-----
Correr para testar a App:
1. Abrir Android Studio e abrir o projeto
2. Compilar a app (se necessário também o build.gradel)
3. Ligar um telemovel com USB debugging ligado
4. Correr a App usando "Run" (Seta verde)
5. Selecionar o dispositivo indicado
(Em alternativa pode criar um "Virtual Device" mas não faz parte da instalação base do AndroidStudio)
<br>[Ajuda](https://developer.android.com/training/basics/firstapp/running-app)

Gerar o Apk:
1. Menu -> Build
2. Build -> Build APK(s)
3. Transferir o ficheiro para um telemóvel
4. Instalar a aplicação
<br>[Ajuda](https://developer.android.com/studio/run/)


UPDATED UML DIAGRAM
-----
![UML](https://github.com/PedroMiguelSilva/Nite/blob/master/ClassDiagram.PNG)

DESIGN PATTERNS USED
-----
Singleton - Ao usar o serviço da Firebase "Realtime Database" usámos um singleton (implementado pelo serviço) onde estabelecemos uma conexão com a base de dados através do SHA1 gerado para identificar a nossa App (lido através do signingReport):

![SHA1](https://github.com/PedroMiguelSilva/Nite/blob/master/sha1.PNG)

No momento em que a conexão foi estabelecida, o conceito de objeto único (típico do Singleton) foi usado para obter a referência ao objeto "FirebaseDatabase" e obter referências às tabelas desejadas:

![SINGLETON](https://github.com/PedroMiguelSilva/Nite/blob/master/getinstance.PNG) 

Encapsulamento - Atributos das Classes do modelo são mantidas privadas com métodos publicos get/set para a sua gestão.

MVC - Tentativa ao DP "Model-View-Controller" no sentido em que há um package com o "Model", onde guarda os elementos "atómicos" do programa; "View" que trata de como o programa se vai manistar visualmente; "Controller" gere as interações. O nosso "Model" é um package com o mesmo nome, com as classes "Event", "User" e "Category". A view são os layouts xml das atividades Android e o Controller as chamadas/atividades como butões e o overload dos seus comportamentos. No entanto, estando pouco familizados com Android esta última divisão é menos clara.

TRIAL AND ERRORS
-----
Inicialmente o projeto tinha como centro de informação uma das nossas páginas pessoais, onde tinhamos vários scripts PHP que manipulavam a nossa base de dados (criada com phpMyAdmin). No entanto, foi abandonada por ser uma abordagem de tão baixo nível e o tempo/foco da cadeira não ser indicado (chamadas http, interpretação e criação de objetos json assim como chamadas em SQL para a base de dados).

Numa iteração seguinte, recriamos o sistema de dados central através da frame-work da Spring, mais especificamente Spring-boot e Spring-data, que nos permitia criar um servidor e nele guardar informação com base em classes criadas com a anotação da framework especificada. Ainda que esta abordagem fosse de muito mais alto nível do que a anteriormente usada, as chamadas à base de dados (ainda que não fosse SQL) eram demasiado baixo nível e o servidor teria um IP variável consoante a máquina-servidor.

No entanto, antes de gerar o .jar para colocar na página pessoal e ter, assim, um servidor apto a chamadas http, decidimos mais uma vez pivotar e mudar todo o nosso sistema de dados para Firebase, por ser uma tecnologia de mais alto nível, mais versatil e mais relevante.

RELEVANT DESIGN DECISIONS
-----
Optamos por usar Firebase (serviço "Real-time Database") para ter um local central de informação. Isso é relevante no âmbito da nossa aplicação no sentido em que ao adicionar um novo "Evento" à base de dados, qualquer Utilizador, em qualquer parte do mundo, terá acesso a essa informação.
Para além disso, usámos uma biblioteca open-source "FirebaseUI database" (implementation 'com.firebaseui:firebase-ui-database:VERSION)
[GitHubFirebaseUi](https://github.com/firebase/FirebaseUI-Android).
Esta biblioteca faciltou a ligação entre Firebase e objetos de display Android.

MAJOR DIFFICULTIES
-----
Dada a quase total liberdade para este projeto, quisemos explorar o máximo possível as tecnologias em que tínhamos curiosidade (Android, http, bases de dado e uso integrado de software de terceiros).
O projeto já tinha sido apresentado como ambicioso (em termos de extensão) e as demasiadas pivotagens durante o desenvolvimento do projeto não ajudaram.
Toda a aprendizagem e implementação em Android foi desafiante, uma curva de aprendizagem relativamente alta para iniciantes sem qualquer tipo de contacto prévio.

LESSONS LEARNED
-----
- Testes unitários a priori são mais utéis no desenvolvimento do que possam parecer. O debug de testes unitários é certamente mais rápido do que o debug visual com Toast's em Android principalmente se isso implicar compilações e instalações de APK morosas.
- Diagramas de estado e preparação em geral (pela entrega intermédia) faz uma diferença enorme em fragmentar o trabalho e consequentemente facilitar o seu desenvolvimento.
- Aprender novas tecnologias não é só aprender como é que elas funcionam, mas também porque é que elas NÃO funcionam. (Caso especialmente notável ao usarmos a biblioteca referida anteriormente - menos exemplos e "soluçoes" apresentadas a erros comuns).

OVERALL TIME SPENT
-----
Pedro Miguel Silva 
60 horas

Miguel Barraca Moura


WORK DISTRIBUTION
-----
Pedro Miguel Silva (50%)<br>
Implementação do sistema de dados
Lógica, testes unitários e documentação

Miguel Barraca Moura (50%)<br>
User Interface
Implementação do gps

USER MANUAL
-----
TODO: Barraca
