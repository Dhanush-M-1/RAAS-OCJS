FROM eclipse-temurin:17-jdk-alpine

RUN java -Xshare:dump 2>/dev/null || true

RUN adduser -D user
USER user
WORKDIR /app
