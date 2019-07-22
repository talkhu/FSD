### Setup

```sh
git clone https://github.com/talkhu/FSD.git

cd FSD
npm install -g json-server
json-server --watch json-server/db.json

cd angular-videos-player
npm i
ng serve # allow localhost only
ng serve --host 0.0.0.0  # via mobile browser
```