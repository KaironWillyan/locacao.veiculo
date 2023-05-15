import { funcionarioDto } from "~/models/Dto/funcionarioDto";

export const useFuncionariorStore = defineStore("funcionario-store", {
    state: () => ({
        funcinoario: [] as funcionarioDto[]
    }),
    actions: {
        async getAll(){
            try{
                let data = await $fetch<funcionarioDto[]>("http://localhost:8080/funcionario")                
                    this.funcinoario = data as funcionarioDto[];
                return data;
            }catch(e: any) {
                useToast().error(e.message);    
            }
        },

        async createFuncionario(data: funcionarioDto) {
            await $fetch("http://localhost:8080/funcionario", {
                method: 'POST',
                body: {data}.data,
            })
            .catch((e)=> {
                useToast().error(e.data.message);
            })
            .then(async ()=>{
                await this.getAll();
                useToast().success("Funcionario cadastrado");
            });
        },

        async updateFuncionario(id: number,data: funcionarioDto) {
            await $fetch(`http://localhost:8080/funcionario/${id}`, {
                method: "PUT",
                body: {data}.data,
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Funcionario atualizado");
            });
        },

        async deleteFuncionario(id: number) {
            await $fetch(`http://localhost:8080/funcionario/${id}`, {
                method: 'DELETE',
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Funcionario deletado")
            })
        }
    }
})