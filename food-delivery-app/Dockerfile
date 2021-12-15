FROM node:14.18.0-alpine as build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install --silent

COPY . ./

EXPOSE 80
# Build the application
# RUN npm run build

CMD ["npm", "start"]