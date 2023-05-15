<script lang="ts">
import AddSetor from '~/components/setor/addSetor.vue';

export default defineComponent({
    async setup() {
        const setores = await useSetorStore().getAll()        
        return { setores };
    },
    components: { AddSetor },
})

</script>

<template>
  <div class="d-flex grid-set">
    <div class="main-setor ">
      <h1>Registrar setor</h1>
         <div class="registro-setor ">
            <AddSetor/>
         </div>
    </div>
    
      <div class="setores-cadastrados">
          <p>Setores</p>
          <p v-for="setor in setores"> {{ setor.nome }}</p>
      </div>
  </div>
</template>

<style scoped>
.main-setor{
    padding: 3%;
    text-align: center;  
}
.registro-setor {
    width: 60%;
    background-color: aqua;
}

.grid-set {
  display: grid;
  grid-gap: 6rem;
}

.setores-cadastrados{
  margin-left: 40%;
  padding: 5%;
  background-color: violet;
}
</style>