
const form1=document.querySelector('#form')

form1.addEventListener('submit',event=>{
    event.preventDefault();
    
    const formData= new FormData(form1);

const data=Object.fromEntries(formData)
console.log(JSON.stringify(data));

      // fetch('http://localhost:8088/signUp', {
       
      //     method: 'POST', // *GET, POST, PUT, DELETE, etc.
      //   //   mode: 'cors', // no-cors, *cors, same-origin             
      //     Headers: {
      //       Accept: 'application.json',
           
      //       'Content-Type': 'application/json'
      //     },
      //     body: JSON.stringify(data),
      //   //   Cache: 'default'
      //   }).then((response) => response.json())
      //   .then((data) => console.log(data)); 

    })
