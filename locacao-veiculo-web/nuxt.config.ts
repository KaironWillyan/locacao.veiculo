// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
    app: {
        pageTransition: { name: 'page', mode: 'out-in' },

    },
    css: ["bootstrap/dist/css/bootstrap.min.css", "bootstrap/dist/css/bootstrap.css", "bootstrap/dist/css/bootstrap-utilities.css", '@vuepic/vue-datepicker/dist/main.css'],
    modules: ['@pinia/nuxt', ],
    pinia: {
        $fetch: {
            URL: "http://localhost:8080",
        },
        autoImports: [
          // automatically imports `defineStore`
          'defineStore', // import { defineStore } from 'pinia'
          ['defineStore', 'definePiniaStore'], 
        ],
    },
})