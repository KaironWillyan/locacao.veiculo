<script lang="ts">
import { Axios } from 'axios';
import AddFuncionario from '~/components/funcionario/AddFuncionario.vue';

definePageMeta({
  layout: 'default'
})

export default defineComponent ({
    setup() {
        const funcionarios = ref([]);
        const axios = useNuxtApp().$axios;
        const fetchFuncionario = async () => await (axios as Axios)
            .get("/funcionario")
            .then((response) => (funcionarios.value = response.data));
        onMounted(fetchFuncionario);
        return { funcionarios };
    },
    components: { AddFuncionario },
    
})
</script>

<template>
  <main>
    <div>
      <AddFuncionario/>

    </div>

      <p>funcionarios</p>
      <p v-for="funcionario in funcionarios">{{ funcionario }}</p>
  
  </main>
</template>

<style scoped>
main {
  width: 100%;
  height: 100%; 
  background-color: green;
}
</style>