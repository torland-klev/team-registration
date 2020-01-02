
const TARGET = "http://localhost:9090";

const createUser = (name, date, image) => {
  const formData = new FormData();
  formData.append('file', image);
  formData.append('name', name);
  formData.append('date', date);
  fetch(TARGET + '/players', {
     method: 'post',
     body: formData
  })
  .then(res => res.json())
  .then(resJson => {
    console.log(resJson);
    if(resJson.id){
      alert("Player uploaded successfully.");
    } else {
      alert("Error occured.");
    }
   });
};

export {
  createUser,
};
