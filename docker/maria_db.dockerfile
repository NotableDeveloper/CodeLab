FROM mariadb:latest

COPY create_db.sh /docker-entrypoint-initdb.d