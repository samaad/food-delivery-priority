import axios from "axios";

const httpCall =  axios.create({
  baseURL: "http://localhost:8082/api/v1",
  headers: {
    "Content-type": "application/json"
  }
});

httpCall.interceptors.request.use(function (config) {
    if(config.url === '/login'){
        return config;
    }else{
        const token = sessionStorage.getItem("TOKEN")
        config.headers.authorization = token
        return config;
    }
  }, function (error) {
    
    return Promise.reject(error);
  });


  export default httpCall;