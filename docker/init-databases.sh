#!/bin/bash

set -e

/create-postgres-databases.sh &

exec docker-entrypoint.sh "$@"