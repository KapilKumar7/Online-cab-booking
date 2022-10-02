
  function myApp() {
      event.preventDefault()
      console.log("Hi")

      fetch('http://localhost:8088/v2/api-docs')
        .then((response) => response.json())
        .then((data) => console.log(data));
  }


