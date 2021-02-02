import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  },

  allLandmark(user){
    return http.get('/get-all/landmarks', user)
  }

}
