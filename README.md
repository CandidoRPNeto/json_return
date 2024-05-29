# Componente conversor de tabelas relacionais para JSON

Esse componente realiza a conversão de tabelas relacionais do seu schema de banco relacional, para o formato JSON, podendo ser utilizado para facilmente converter bancos relacionais em não relacionais ou para integração direta com o front-end.

## Instalação

Use o Driver JDBC do seu banco de dados no classpath do seu projeto.
Exemplo:
```xml
    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version> 
        </dependency>
    </dependencies>
```
## Uso

1. **Inicializando o Componente**:
   Inicialize o componente passando as credenciais do seu Banco de Dados.
   
```java
Component component = new Component("jdbc:postgresql://localhost:5432/banco", "usuario", "senha");
```

2. **Geraçao do JSON**
  Utilize o método createJson da classe Component para gerar um JSON com os dados de uma tabela específica.

  ```java
  String json = component.createJson("pg_database");
  ```
3. **Utilização do JSON**
  Agora você tem o resultado da conversão da consulta para JSON em uma String
  
  ```java
  System.out.println(json);
  ```
  
  Exemplo de resultado:
   ```json
   {
    "user_id": "71f9ae03-e334-47d0-a386-736d632841aa",
    "email": "wladi@email.com",
    "name": "Wladi",
    "password": "123"
  }
  ```
