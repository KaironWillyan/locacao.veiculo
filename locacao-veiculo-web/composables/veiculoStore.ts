import { veiculoDto } from "~/models/Dto/veiculoDto";

export const useVeiculoStore = defineStore("veiculo-store", {
    state: () => ({
        veiculo: [] as veiculoDto[]
    }),
    actions: {
        async getAll() {
            try{
                const data = await $fetch<veiculoDto[]>("http://localhost:8080/veiculo");
                    this.veiculo = data as veiculoDto[];
                return data ;
            }catch(e: any){
                useToast().error(e.message);
            }
        },

        async createVeiculo(data: veiculoDto) {
            await $fetch("http://localhost:8080/veiculo", {
                method: 'POST',
                body: {data}.data,
            })
            .catch((e)=> {
                useToast().error(e.data.message);
            })
            .then(async ()=>{
                await this.getAll();
                useToast().success("Veiculo cadastrado");
            });
        },

        async updateSetor(data: veiculoDto) {
            await $fetch(`http://localhost:8080/veiculo/${data.id}`, {
                method: "PUT",
                body: {data},
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Veiculo atualizado");
            });
        },

        async deleteSetor(id: number) {
            await $fetch(`http://localhost:8080/veiculo/${id}`, {
                method: 'DELETE',
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Veiculo deletado")
            })
        }
    }
})