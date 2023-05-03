<script lang>
definePageMeta({
  layout: 'default'
})

export default defineComponent ({
    setup() {
      const funcionario = ref([]);
      const context = useNuxtApp();

      const fetchFuncionario = async () => 
      await
        context.$axios
         .get("/funcionario")
         .then((response) => (funcionario.value = response.data));

      onMounted(fetchFuncionario);
      return {funcionario};
    },
})
</script>

<template>
  <main>
      <p>funcionario</p>
      <p>{{ funcionario }}</p>
      <p v-for="funcionarios in funcionario">{{ funcionarios }}</p>
  
  </main>
</template>

<style scoped>
main {
  width: 100%;
  height: 100%; 
  background-color: green;
}
</style>