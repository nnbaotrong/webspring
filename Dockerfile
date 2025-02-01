# Bước 1: Sử dụng image chính thức của OpenJDK để build ứng dụng
FROM openjdk:17-jdk-slim as build

# Bước 2: Cài đặt Maven
RUN apt-get update && apt-get install -y maven

# Bước 3: Sao chép mã nguồn từ máy chủ của bạn vào container
COPY . /app

# Bước 4: Chuyển vào thư mục ứng dụng
WORKDIR /app

# Bước 5: Build ứng dụng Spring Boot bằng Maven
RUN mvn clean package -DskipTests

# Bước 6: Sử dụng lại image OpenJDK để chạy ứng dụng
FROM openjdk:17-jdk-slim

# Bước 7: Sao chép file JAR đã build từ bước trước
COPY --from=build /app/target/webspring-0.0.1-SNAPSHOT.jar /webspring.jar

# Bước 8: Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/webspring.jar"]

# Expose port cho ứng dụng
EXPOSE 8080
