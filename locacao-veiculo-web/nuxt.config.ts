// https://nuxt.com/docs/api/configuration/nuxt-config

export default defineNuxtConfig({
    app: {
        pageTransition: { name: 'page', mode: 'out-in' },

    },
    css: ["bootstrap/dist/css/bootstrap.min.css", "bootstrap/dist/css/bootstrap.css", "bootstrap/dist/css/bootstrap-utilities.css"],
    modules: ['@pinia/nuxt'],
    pinia: {
        autoImports: [
          // automatically imports `defineStore`
          'defineStore', // import { defineStore } from 'pinia'
          ['defineStore', 'definePiniaStore'], // import { defineStore as definePiniaStore } from 'pinia'
        ],
    },
})
