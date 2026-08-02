FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN javac -cp "lib/*" src/*.java

CMD ["java", "-cp", "src:lib/*", "Main"]