import { funcionarioDto } from "./funcionarioDto";
import { operadorDto } from "./operdorDto";
import { veiculoDto } from "./veiculoDto";

export interface locacaoDto {
    id              ?:number;
    funcionario     :funcionarioDto;
    operador        :operadorDto;
    veiculo         :veiculoDto;
    dtLocacao      :Date;
    dtEntrega      :Date;
    kmLocacao      :number;
    kmEntrega      :number;
}