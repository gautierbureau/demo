## PostgreSQL

``` bash
$> ./configure --prefix=<PREFIX>
$> make
$> make install
$> cd <PREFIX>
$> bin/initdb -D ./data
$> echo "host  all  all 0.0.0.0/0 md5" >> data/pg_hba.conf
$> bin/pg_ctl -D ./data start
$> bin/psql postgres -c  "CREATE USER postgres WITH PASSWORD 'postgres' SUPERUSER;"
$> bin/pg_ctl -D ./data stop
$> bin/postgres -D ./data --listen_addresses='*'
```

## Liquibase

``` bash
$> mvn clean compile liquibase:update liquibase:diff 
```

## Docker

``` bash
$> mvn clean compile jib:dockerBuild # Build locally
$> mvn clean compile jib:build -Djib.to.auth.username=<USER> -Djib.to.auth.password=<PASSWORD> # Build and publish
```

## Docker compose

``` bash
$> cd docker
$> docker-compose up
$> docker-compose down
```

```bash 
$> docker-compose exec demo-postgres psql -U postgres demo
```

## Run

``` bash
$> java -jar target/demo-0.0.1-SNAPSHOT.jar 
```

## Test API

``` bash
$> curl -X POST http://localhost:8080/person\?first_name\=test1\&last_name\=test2
```

## Swagger

```
http://localhost:8080/swagger-ui.html 
```

## Javadoc

``` bash
$> mvn javadoc:javadoc
$> open target/site/apidocs/index.html
```