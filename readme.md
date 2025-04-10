Aluno: Felipe Ros Segundo Simão
Matrícula: 202310206442

**É RECOMENDADO A UTILIZAÇÃO DA IDE INTELLIJ PARA EXECUTAR ESTE CÓDIGO**

Para executar o projeto, primeiramente deve executar o docker-compose
ou estar com o MySQL rodando em sua máquina (independente de sistema operacional).

Com o MySQL rodando é necessário definir na classe "Main" qual o endereço de conexão do banco de dados

Exemplo:

```java
import fun.felipe.configs.database.DatabaseConfig;

DatabaseConfig  databaseConfig = new DatabaseConfig(
        "localhost", //SEU ENDEREÇO DE CONEXÃO
        3306, //SUA PORTA DE CONEXÃO
        "dev_db", //BANCO DE DADOS
        "dev", //USUÁRIO
        "root" //SENHA
);
```

Após configurar a conexão com banco de dados deve executar o código uma primeira vez.
Essa primeira inicialização fará o processo de criação das tabelas.

Os fornecedores não tem meio de registro via aplicação então é necessário
definir manualmente no banco de dados. Porém as relações funcionam
então é necessário esse cadastro.

i18n foi implementado, pego via System.getProperty();
pode ser modificado para receber o código da lingua para testes

pt = português
en = inglês