import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });


  export default { 
      searchLandmark(user, day, location, venueType){
        return http.get(`/search-landmarks/${day}/${location}/${venueType}`,user)
      },
    
      allCities(){ 
        return http.get('/cities');   
      },

      getLandmarkByCity(cityName){ 
        return http.get('/landmarks-city/', cityName);   
      },
    
  }