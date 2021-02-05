import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });


  export default { 
      searchLandmark(day, location, venueType, CurrentTime){
        return http.get(`/search-landmarks/${day}/${location}/${venueType}/${CurrentTime}`)
      },
    
      allCities(){ 
        return http.get('/cities');   
      },

      getLandmarkByCity(cityName){ 
        return http.get(`/landmarks-city/${cityName}`);   
      },
    
  }