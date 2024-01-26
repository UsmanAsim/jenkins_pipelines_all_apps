# FROM node:16-alpine as builder

# WORKDIR '/usr/app'

# COPY /package.json .

# RUN npm install

# COPY . .

# RUN npm run build

# FROM nginx

# COPY --from=builder /usr/app/build /usr/share/nginx/html

FROM node:14-alpine

WORKDIR '/usr/app'

COPY package.json .

RUN npm install

COPY . .

CMD ["npm","start"]
