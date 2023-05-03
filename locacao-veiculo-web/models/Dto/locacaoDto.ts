import { funcinarioDto } from "./funcionarioDto";
import { operadorDto } from "./operdorDto";
import { veiculoDto } from "./veiculoDto";

export interface locacaoDto {
    id              :number;
    funcionario     :funcinarioDto;
    operador        :operadorDto;
    veiculo         :veiculoDto;
    dt_locacao      :Date;
    dt_entrega      :Date;
    km_locacao      :number;
    km_entrega      :number;
}