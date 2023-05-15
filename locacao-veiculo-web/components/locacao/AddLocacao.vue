<script setup lang="ts">
import { locacaoDto } from '~/models/Dto/locacaoDto';
import VueDatePicker from '@vuepic/vue-datepicker'
const locarStore = await useLocacaoStore();
const funcionarioStore = await useFuncionariorStore().getAll();
const operadorStore = await useOperadorStore().getAll();
const veiculoStore = await useVeiculoStore().getAll();

const data = await ref({
    dtLocacao: {},
    dtEntrega: {},
    kmLocacao: 0,
    kmEntrega: 0,
    funcionario:{},
    operador:   {},
    veiculo:    {}
} as locacaoDto)

async function addLocacao(){
   await locarStore
    .createLocacao({
    dtLocacao:  data.value.dtLocacao,
    dtEntrega:  data.value.dtEntrega,
    kmLocacao:  data.value.kmLocacao,
    kmEntrega:  data.value.kmEntrega,
    funcionario: data.value.funcionario,
    operador:    data.value.operador,
    veiculo:     data.value.veiculo,
    })

}
</script>

<template>
<form>
    <div class="mb-3">
      <label class="form-label">Data da locação</label>
      <!-- <input type="datetime" @keyup.enter="addLocacao" onerror="" v-model="data.dtLocacao" class="form-control" aria-describedby="emailHelp"> -->
      <VueDatePicker v-model="data.dtLocacao" @keyup.enter="addLocacao" vertical/>
      
    </div>
    <div class="mb-3">
      <label class="form-label">Data Devolução </label>
      <!-- <input @keyup.enter="addLocacao" v-model="data.dtEntrega" type="datetime" class="form-control"> -->
      <VueDatePicker v-model="data.dtEntrega" @keyup.enter="addLocacao" vertical/>

    </div>
    <div class="mb-3">
      <label class="form-label">Quilometragem Locação</label>
      <input @keyup.enter="addLocacao" v-model="data.kmLocacao" type="text" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Quilometragem Devolução</label>
      <input @keyup.enter="addLocacao" v-model="data.kmEntrega" type="text" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Funcionário</label>
      <select v-model="data.funcionario" @keyup.enter="addLocacao" class="form-select form-select-sm" aria-label=".form-select-sm example">
          <option :value="funcionario" v-for="funcionario in funcionarioStore"> {{funcionario.nome}} {{ funcionario.setor.nome}}</option>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">Veículo</label>
      <select v-model="data.veiculo" @keyup.enter="addLocacao" class="form-select form-select-sm" aria-label=".form-select-sm example">
          <option selected>Selecione o veiculo</option>
          <option :value="veiculo" v-for="veiculo in veiculoStore"> {{veiculo.modelo}} {{ veiculo.placa }} {{ veiculo.cor }}</option>
      </select>
    </div>
    <div class="mb-3">
      <label class="form-label">operador</label>
      <select v-model="data.operador" @keyup.enter="addLocacao" class="form-select form-select-sm" aria-label=".form-select-sm example">
          <option selected>Selecione o operador</option>
          <option :value="operador" v-for="operador in operadorStore"> {{operador.nome}}</option>
      </select>
    </div>

    <button @keyup.enter="addLocacao" @click="addLocacao" type="button" class="btn btn-primary">Cadastrar</button>
  </form>
</template> 