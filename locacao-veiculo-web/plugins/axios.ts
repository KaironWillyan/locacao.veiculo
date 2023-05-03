import axios from "axios";
export default defineNuxtPlugin(nuxtApp => {
  return {
    provide: {
      axios: axios.create({
        baseURL : "http://localhost:8080" || process.env.API_URL,
    })
    }
  }
})