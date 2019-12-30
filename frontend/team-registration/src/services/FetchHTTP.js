
const TARGET = "http://localhost:9090";

const createUser = (name, date, image) => {
  const formData = new FormData();
  formData.append('file', image);
  formData.append('name', name);
  formData.append('date', date);
  fetch(TARGET + '/players', {
     method: 'post',
     body: formData
  }).then(res => {
    if(res.ok) {
      console.log(res);
      alert("Player uploaded successfully.")
    }
   });
};

export {
  createUser,
};
