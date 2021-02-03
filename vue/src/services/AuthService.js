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

  allLandmark(){ 
    return http.get('/get-all/landmarks', {headers: {'Authorization' : this.$store.state.token}});   
  },

  searchLandmark(user, day, location, venueType){
    return http.get(`/search-landmarks/${day}/${location}/${venueType}`,user)
  }

}
