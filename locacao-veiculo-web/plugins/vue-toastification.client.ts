import Toast from "vue-toastification";
import "vue-toastification/dist/index.css"
import appVue from "~/app.vue";

export default defineNuxtComponent(nuxtApp => {
   return appVue.Vue.use(Toast);
})

