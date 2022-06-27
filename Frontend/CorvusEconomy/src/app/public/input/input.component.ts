import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Entrada } from 'src/app/security/model/entrada.model';
import { EntradaService } from 'src/app/security/service/entrada.service';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {
  input?: Entrada = new Entrada();
  public invalid?: boolean;
  constructor(
    private router: Router,
    private formBuilder : FormBuilder,
    private inputService:EntradaService
  ) { 
    
  }
  selected = '';
  onSelected(value:string): void {
    this.selected = value;
  }
  selected1 = '';
  onSelected1(value:string): void {
    this.selected1 = value;
  }
  selected2 = '';
  onSelected2(value:string): void {
    this.selected2 = value;
  }
  selected3 = '';
  onSelected3(value:string): void {
    this.selected3 = value;
  }
  selected4 = '';
  onSelected4(value:string): void {
    this.selected4 = value;
  }

  form = this.formBuilder.group({
      name: [''],
      v_nominal:[''],
      v_comercial:[''],
      n_años:[''],
      ta_anual_desc: [''],
      fch_emision: [''],
      prima: [''],
      estructuracion: [''],
      colocacion: [''],
      flotacion: [''],
      user_id: this.formBuilder.group({
        "id":[1]
      }),
      moneda_id: this.formBuilder.group({
        "id":[this.selected]
      }),
      frecuencia_id: this.formBuilder.group({
        "id":[this.selected1]
      }),
      tanho_id: this.formBuilder.group({
        "id":['']
      }),
      tipointeres_id : this.formBuilder.group({
        "id":['']
      }),
      capitalizacion_id : this.formBuilder.group({
        "id":['']
      }),
      impuestoR: [''],
      cavali: [''],
      tasa_interes:[''],
     
    });
   

    userId(): number{
      let user = localStorage.getItem("ng-auth");
      if(user){
      let ObjUser = JSON.parse(user);
      return ObjUser.id;
      }
      return -1;
    }
    onSubmit(): void{
      let self = this;
    this.inputService.save(this.form.value).subscribe({
      next(data) {
        console.log('Success!',data),
        self.router.navigate(['/output']);
      },
      error() {
        self.invalid = true;
      },
  })
    }

  ngOnInit(): void { 

  }

}
