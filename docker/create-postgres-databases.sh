#!/bin/bash

set -e

function createDatabases()
{
psql --username $POSTGRES_USER --dbname $POSTGRES_DEFAULT_DB <<-EOSQL
  create database "demo";
EOSQL
}

until pg_isready; do
  echo "psql: Postgres is unavailable to create databases - will retry later"
  sleep 2
done && createDatabases