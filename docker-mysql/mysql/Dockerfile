#使うDockerイメージ
FROM mysql:5.7

#ポートを開ける
EXPOSE 3306

#MySQL設定ファイルをイメージ内にコピー
COPY ./my.cnf /etc/mysql/conf.d/my.cnf
#初期データ
COPY ./mysql-dump /docker-entrypoint-initdb.d
#docker runに実行される
CMD ["mysqld"]

