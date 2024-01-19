# FROM：ベースイメージの指定
#  Spring InitializrでJava17を指定したので合わせる
FROM openjdk:17-jdk-slim

# アプリケーションのjarファイルへのパスを変数として定義
ARG JAR_FILE=target/*.jar

# jarファイルをDockerイメージ内の指定された場所にコピー
COPY ${JAR_FILE} app.jar

# コンテナがリッスンするポートを指定
EXPOSE 8080

# Dockerコンテナ起動時に実行されるコマンド
ENTRYPOINT ["java","-jar","/app.jar"]