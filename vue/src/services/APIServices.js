import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });


  export default {
    allLandmark(){ 
        return http.get('/get-all-landmarks');   
      },
    
      searchLandmark(user, day, location, venueType){
        return http.get(`/search-landmarks/${day}/${location}/${venueType}`,user)
      },
    
      allCities(){ 
        return http.get('/cities');   
      },
    
  }