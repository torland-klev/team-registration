
const TARGET = "http://localhost:9090";

const createUser = (name, date, image) => {
  const formData = new FormData();
  formData.append('profileImage', image);
  formData.append('name', name);
  formData.append('birthday', date);
  fetch(TARGET + '/players', {
     method: 'post',
     body: formData
  })
  .then(res => res.json())
  .then(resJson => {
    console.log(resJson);
    if(resJson.id){
      alert("Player (id=" + resJson.id +") uploaded successfully.");
    } else {
      alert("Error occured.");
    }
   });
};

export {
  createUser,
};
