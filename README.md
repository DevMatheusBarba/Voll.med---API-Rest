# API voll.med

## Descrição
API permite o cadastro e gerenciamento de médicos, pacientes e consultas médicas, facilitando a organização de dados e a marcação de consultas.

# Tecnologia Utilizada
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) - Linguagem de progração voltado

 ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) -  Framework para construção de APIs com **Java**

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) - Banco de dados relacional

![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens) - Para autenticações mais seguras

**MockMvc** - Para testes automatizados por unidade

**Flyway** - Para gravar historico do banco de dados

**Bean Validation** - Para fazer validação de conteudos entregues a API




## Índice
- [Tecnologia Utilizadas](#tecnologia-utilizada)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Contato](#contato)

# Instalação
### Requisitos
- [Java JDK 21](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/download/?section=windows)
- [Postman](https://www.postman.com/downloads/)
  
### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/DevMatheusBarba/Voll.med---API-Rest.git

## Configuração

1. Crie um banco de dados nomeado como **voll.med** no postgreSQL
    > **OBS:**
    > 
    > Caso crei o banco com outro nome precisa alterar o o endereço no **src/main/resources/application.yml** na propriedade spring.datasource.url .

2. Crie um banco  nomeado como **voll.med_test** no postgreSQL
    > **OBS:**
    > 
    > Caso crei o banco com outro nome precisa alterar o o endereço no **src/main/resources/application-test.yml** na propriedade spring.datasource.url .

3. Crie um usuário no banco de dados.
    > Acesse o Query Tool do banco de dados **voll.med** clicando com o botão direito em cima dele pelo administrador de banco de dados
    > ```bash
    > INSERT INTO usuarios (login, senha) VALUES ('exemplo@dominio.com', 'suaSenhaSegura');
    >```
    > Utilize senhas criptografadas! recomendação de utilizar o [site](https://bcrypt-generator.com/)

      >**OBS**
      >Não foi criado um **ENDPOINT** para cadastrode usuários para segurança da aplicação

## Uso

#### 1. Rode a aplicação
  - Intellij
    > Execute o unico método existente dentro da **Class** **ApiApplication**
```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-07-01T14:25:13.875-03:00  INFO 131388 --- [  restartedMain] med.vol.api.ApiApplication               : Starting ApiApplication using Java 21.0.3 with PID 131388 (C:\Users\matheus.silva\Desktop\Projeto\Voll.med---API-Rest\target\classes started by matheus.silva in C:\Users\matheus.silva\Desktop\Projeto\Voll.med---API-Rest)
2024-07-01T14:25:13.879-03:00  INFO 131388 --- [  restartedMain] med.vol.api.ApiApplication               : No active profile set, falling back to 1 default profile: "default"
2024-07-01T14:25:13.978-03:00  INFO 131388 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-07-01T14:25:13.978-03:00  INFO 131388 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-07-01T14:25:15.769-03:00  INFO 131388 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-07-01T14:25:15.937-03:00  INFO 131388 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 154 ms. Found 4 JPA repository interfaces.
2024-07-01T14:25:17.275-03:00  INFO 131388 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-07-01T14:25:17.298-03:00  INFO 131388 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-07-01T14:25:17.298-03:00  INFO 131388 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.24]
2024-07-01T14:25:17.401-03:00  INFO 131388 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-07-01T14:25:17.403-03:00  INFO 131388 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3423 ms
2024-07-01T14:25:17.866-03:00  INFO 131388 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-07-01T14:25:18.464-03:00  INFO 131388 --- [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@4cbb0212
2024-07-01T14:25:18.466-03:00  INFO 131388 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-07-01T14:25:18.508-03:00  INFO 131388 --- [  restartedMain] org.flywaydb.core.FlywayExecutor         : Database: jdbc:postgresql://localhost/voll.med (PostgreSQL 16.3)
2024-07-01T14:25:18.634-03:00  INFO 131388 --- [  restartedMain] o.f.core.internal.command.DbValidate     : Successfully validated 10 migrations (execution time 00:00.091s)
2024-07-01T14:25:18.806-03:00  INFO 131388 --- [  restartedMain] o.f.core.internal.command.DbMigrate      : Current version of schema "public": 10
2024-07-01T14:25:18.812-03:00  INFO 131388 --- [  restartedMain] o.f.core.internal.command.DbMigrate      : Schema "public" is up to date. No migration necessary.
2024-07-01T14:25:19.043-03:00  INFO 131388 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-07-01T14:25:19.240-03:00  INFO 131388 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.5.2.Final
2024-07-01T14:25:19.344-03:00  INFO 131388 --- [  restartedMain] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2024-07-01T14:25:19.956-03:00  INFO 131388 --- [  restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-07-01T14:25:21.744-03:00  INFO 131388 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2024-07-01T14:25:21.749-03:00  INFO 131388 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-07-01T14:25:22.414-03:00  INFO 131388 --- [  restartedMain] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with UserDetailsService bean with name autenticacaoService
2024-07-01T14:25:22.528-03:00  INFO 131388 --- [  restartedMain] o.s.d.j.r.query.QueryEnhancerFactory     : Hibernate is in classpath; If applicable, HQL parser will be used.
2024-07-01T14:25:23.579-03:00  WARN 131388 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-07-01T14:25:26.058-03:00  INFO 131388 --- [  restartedMain] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@30adca01, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@12b5f333, org.springframework.security.web.context.SecurityContextHolderFilter@628300cc, org.springframework.security.web.header.HeaderWriterFilter@dc28d55, org.springframework.web.filter.CorsFilter@2ae077b7, org.springframework.security.web.authentication.logout.LogoutFilter@9cb94af, med.vol.api.infra.security.SecurityFilter@1e7b11f4, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@17105154, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@6f862e34, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@d064794, org.springframework.security.web.session.SessionManagementFilter@227a230f, org.springframework.security.web.access.ExceptionTranslationFilter@4f4bed3b, org.springframework.security.web.access.intercept.AuthorizationFilter@3a931522]
2024-07-01T14:25:26.760-03:00  INFO 131388 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-07-01T14:25:26.827-03:00  INFO 131388 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-07-01T14:25:26.844-03:00  INFO 131388 --- [  restartedMain] med.vol.api.ApiApplication               : Started ApiApplication in 13.961 seconds (process running for 15.553)
```

  >Código similar a este deve aparecr em sua tela! A aplicação está rodando na **URL** http://localhost:8080
>Para confirma acesse a URL http://localhost:8080/hello no seu broser, deve aparecer a seguinte mensagem
>```bash
>Hello Word Spring
>``` 

  - CMD
    > Execute o comando abaixo dentro da pasta do projeto
    > ```bash
    > java -jar target/api-0.0.1-SNAPSHOT.jar
    > ```
    >Uma mensagem similiar a execução via Intellij deve aparecer em seu terminal
#### 2. Disparando requisição
   > Todo o projeto está com o modulo de autenticação via Token, sendo liberado a principio apenas requisição de login! Para isso vamos utilziar o **Postman**
   > Vai disparr uma requisição do tipo **POST** para a URL **http://localhost:8080/login** passando no corpo um **JSON** contendo o email e senha cadastrado no banco de dados, feito em [Configuração](#configuração) tópico 3.
   > EX
   > ```bash
   > {
   > login:"exemplo@dominio.com"
   > senha:"123456"
   > }
   > ```
   > **OBS**
   > Os campos login e senha sempre terá esses nomes, pois é como está definido na aplicação! Sómente seus valores serão alterado. A senha deve ser passada em texto claro, isso quer dizer que não precisa ser passado de forma criptografada, a propria aplicação irá efetuar o processo de descriptografar
   >
   > Feito isso você deve receber um token com para liberar as demais requisições **OBS** esse token é valido por 2 horas após a sua criação

#### 3. Listando **Endpoints**

>Podemos pegar a lista de **Endpoints** presente em nossa aplicação acessando a **URL**
>
>http://localhost:8080/swagger-ui/index.html#/
>
>Você vai conseguir encontrar toda a documentação de forma visual sobre os endpoints e o que cada class precisa receber para que tudo possa ocorrer corretamente



# Contato

Para mais informações, entre em contato pelo email: matheus.silva081@icloud.com


## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.





