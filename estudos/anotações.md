
# Anotações referentes a estudos e observações importantes

#### Projeto criado junto ao canal do *Matheus Leandro Ferreira*.

[Vídeo do Youtube usado como referência](https://www.youtube.com/watch?v=HeI-POYZk7g)


#### Execução do projeto na linha de comando

`mvn spring-boot:run`

### Vamos utilizar o Postgres como banco de dados para o curso. Para usar via docker, comando:

    `docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=meubanco -p 5432:5432 -d postgres`

### Postgres:

- Logar no Postgres via WSL terminal:

`sudo -u postgres psql`

- Criar banco: 

`CREATE DATABASE nome-banco;`

- Listar Bancos: 

`\l`

- Acessar o banco diretamente:

`sudo -u postgres psql` ... restante do comando, as vezes, somente o comando de baixo dá erro
`psql -U postgres -d nome_do_banco`


- Criar usuário para o banco:

`CREATE USER nome_usuario WITH PASSWORD 'senha_usuario'`

- Concedendo permissões para usuário conectar ao banco de dados:

`\c nome_do_banco`
`GRANT CONNECT ON DATABASE nome_do_banco TO nome_do_usuario;`

- Conceder permissões para criar objetos (como tabelas) no banco de dados:

`GRANT CREATE ON DATABASE nome_do_banco TO nome_do_usuario;`

- Conceder permissões de leitura e escrita (seleção e atualização) nas tabelas do banco:

`GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO nome_do_usuario;`

- Para evitar erros de permissão, podemos conceder todas as permissões para o usuário: 

`GRANT ALL PRIVILEGES ON SCHEMA public TO nome_usuario;`

- Testar acesso do novo usuário:

`psql -U nome_do_usuario -d nome_do_banco -W`

- Sair do PG no WSL:

`\q`

### Por limitações da extensão Thunder Client no WSL, estamos utilizando a extensão REST Client para testar nossos endpoints, para conhecer mais a respeito:

[Artigo Dev.to: VSCode - REST Client](https://dev.to/leandroats/vscode-rest-client-2cei)


### OBS: 

Usar projeto como base para criar API com autenticação JWT e cadastro de usuário.
Estrutura para PostgreSQL que pode ser facilmente substituído alterando a lib no POM 
e trocando as configurações no arquivo application.properties.


### Comandos utilizados: 

- Criação do banco de cadastro de pedido

`CREATE DATABASE ms_pedido;`

- Conectar ao banco ms_pedido

`\c ms_pedido`

- Conceder todas as permissões ao usuário admin/admin (criado anteriormente em outro projeto)

`GRANT CONNECT ON DATABASE ms_pedido TO admin;`
`GRANT CREATE ON DATABASE ms_pedido TO admin;`
`GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO admin;`
`GRANT ALL PRIVILEGES ON SCHEMA public TO admin;`

### Configuração do RabbitMQ

- Usar na Controller classe RabbitTemplate;
- Configurar propriedades no arquivo `application.properties`

#### Criação do Broker no CloudAMQP

[Site CloudAMQP](https://www.cloudamqp.com/)

Login criado com conta do github. Plano Free disponível, criar time ou utilizar algum (se já criado).

Configurar uma nova instância com nome, provedor, região, validar sempre que o plano gratuito foi selecionado!

Criamos um novo Exchange (fila) através do site do CloudAMQP, pelo portal do LavinMQ disponível ao acessar a instância.

Acessando a opção `Exchanges` no menu lateral esquerdo, fica disponível uma lista com 6 exchanges default e logo abaixo a opção para criar um novo. Definimos o nome e ja podemos clicar em `Add exchange`, ou se for o caso, podemos trocar o tipo de exchange, por default, vem selecionado o tipo `direct`.


#### Testes com projetos

Abrir em abas diferentes no VSCode ou usar VSCode + IntelliJ para rodar paralelamente, abrir os 2 na mesma workspace pode dar conflitos.

Se preferir e não precisar de Debug, utilize o terminal (Windows terminal ou do VSCode ou IntelliJ) e inicialize na pasta de cada projeto individualmente via CLI com maven através do comando:

`mvn spring-boot:run`

Caso precise atualizar o projeto, instalar dependências:

`mvn clean install`