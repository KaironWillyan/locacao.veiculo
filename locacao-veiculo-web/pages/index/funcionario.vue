<script lang="ts">
import AddFuncionario from '~/components/funcionario/AddFuncionario.vue';

export default defineComponent ({
    async setup() {
      const funcionarios = await useFuncionariorStore().getAll()
      return {funcionarios}
    },
    components: { AddFuncionario },
})
</script>

<template>
  <div>
    <h1>Cadastro de funcionario</h1>
    <div>
      <AddFuncionario/>
    </div>

      <div>
        <p>funcionarios</p>
        <p v-for="funcionario in funcionarios">{{ funcionario }}</p>
      </div>
  
  </div>
</template>

<style scoped>
main {
  width: 100%;
  height: 100%; 
  background-color: green;
}
</style>