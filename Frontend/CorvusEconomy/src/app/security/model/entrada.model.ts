import { TipoInteres } from './TipoInteres.model';
import { Tipoanho } from './tipoaño.model';
import { Frecuencia } from './frecuencia.model';
import { Capitalizacion } from './capitalizacion.model';
import { User } from "./user.model";
import { Moneda } from './moneda.model';

export class Entrada{
    id?: number;
    name?: string;
    v_nominal?: number;
    v_comercial?: number;
    n_años?: number;
    ta_anual_desc?: number;
    ImpuestoR?: number;
    fch_emision?: Date;
    prima?: number;
    estructuracion?: number;
    colocacion?: number;
    flotacion?: number;
    cavali?: number;
    tasa_interes?:number;
    user_id?:User[];
    frecuencia_id?:Frecuencia[];
    tanho_id?:Tipoanho[];
    tipointeres_id?:TipoInteres[];
    capitalizacion_id?:Capitalizacion[];
    nomeda_id?:Moneda[];
}