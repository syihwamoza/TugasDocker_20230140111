FROM eclipse-temurin:25-jdk
# Gunakan bintang (*) agar mencari file jar apapun di folder target
ARG JAR_FILE=target/*.jar
# Gunakan variabel JAR_FILE yang sudah didefinisikan di atas
#COPY ${JAR_FILE} app.jar
COPY ./target/deploy-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8088