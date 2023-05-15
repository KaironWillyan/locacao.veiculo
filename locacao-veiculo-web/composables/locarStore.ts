import { locacaoDto } from "~/models/Dto/locacaoDto";

export const useLocacaoStore = defineStore("locar-store", {
    state: () => ({
        locacao: [] as locacaoDto[]
    }),
    actions: {
        async getAll(){
            try{
                let data = await $fetch<locacaoDto[]>("http://localhost:8080/locar")                
                    this.locacao = data as locacaoDto[];
                return data;
            }catch(e: any) {
                useToast().error(e.message);    
            }
        },

        async createLocacao(data: locacaoDto) {
            await $fetch("http://localhost:8080/locar", {
                method: 'POST',
                body: data,
            })
            .catch((e)=> {
                useToast().error(e.data.message);
            })
            .then(async ()=>{
                await this.getAll();
                useToast().success("Locacao cadastrado");
            });
        },

        async updateFuncionario(id: number,data: locacaoDto) {
            await $fetch(`http://localhost:8080/locar/${id}`, {
                method: "PUT",
                body: {data},
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Locacao atualizado");
            });
        },

        async deleteFuncionario(id: number) {
            await $fetch(`http://localhost:8080/locar/${id}`, {
                method: 'DELETE',
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Locacao deletado")
            })
        }
    }
})