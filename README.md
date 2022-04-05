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
