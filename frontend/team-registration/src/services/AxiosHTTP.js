import axios from 'axios';

const TARGET = "http://localhost:9090";


const createUser = (name, date, image) => {
  axios.post(TARGET + '/players', {
      name: 'Name',
      date: 'Date'
    })
    .then(res => {
    console.log(res);
  })
};

export {
  createUser,
};
