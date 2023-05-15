<script setup lang="ts">
import { veiculoDto } from '~/models/Dto/veiculoDto';

const veiculoStore = await useVeiculoStore()

let data = ref({
    cor: "",
    modelo: "",
    placa: "",
    tipo_combustivel: "",
}as veiculoDto)

async function addVeiculo() {
    await veiculoStore
      .createVeiculo( {
        cor: data.value.cor,
        modelo: data.value.modelo,
        placa: data.value.placa,
        tipo_combustivel: data.value.tipo_combustivel,
    })
}

</script>

<template>
  

<form>
  <div class="mb-3">
    <label class="form-label">Modelo</label>
    <input type="text" @keyup.enter="addVeiculo" v-model="data.modelo" class="form-control" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label class="form-label">Cor</label>
    <input @keyup.enter="addVeiculo" v-model="data.cor" type="text" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Placa</label>
    <input @keyup.enter="addVeiculo" v-model="data.placa" type="text" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Tipo de Combustivel</label>
    <input @keyup.enter="addVeiculo" v-model="data.tipo_combustivel" type="text" class="form-control">
  </div>
  <button @keyup.enter="addVeiculo" @click="addVeiculo" type="button" class="btn btn-primary">Cadastrar</button>
</form>


</template>

