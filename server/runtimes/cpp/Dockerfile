FROM alpine:3.19

RUN apk add --no-cache g++ gcc musl-dev make

RUN adduser -D user
USER user
WORKDIR /app
