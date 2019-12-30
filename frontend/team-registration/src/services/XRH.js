var xhr = new XMLHttpRequest();
const TARGET = "http://localhost:9090";

const createUser = (name, date, image) => {
  xhr.open('POST', TARGET + '/players');
  xhr.send(JSON.parse('{"name": "name","date": "date"}'));
};

export {
  createUser,
};
