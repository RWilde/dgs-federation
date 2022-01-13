FROM node:latest

RUN mkdir gateway
COPY gateway-service/package.json ./package.json
COPY gateway-service/gateway.js ./gateway.js
RUN npm i

CMD node gateway.js