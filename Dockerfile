FROM gradle:8.4.0-jdk17-alpine AS builder
WORKDIR /home/gradle/project
COPY . .
RUN gradle clean build -x test --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/app1-1.0-SNAPSHOT