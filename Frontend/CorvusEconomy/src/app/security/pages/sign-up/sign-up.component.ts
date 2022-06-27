import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../model/user.model';
import { IdentityService } from '../../service/identity.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public invalid?: boolean;
  userModel = new User();
  constructor(
    private registroService: IdentityService,
    private fb: FormBuilder,
    private router: Router
  ) { }
  submitted = false;
  registroForm = this.fb.group({
   username: [''],
   password: [''],
   email: [''],
   phone: [''],
   rol: ['USER']
  })

  ngOnInit(): void {
  }

  onSubmit(): void{
    let self = this;
    this.registroService.create(this.registroForm.value).subscribe({
      next(data) {
        console.log('Success!',data),
        
        self.router.navigate(['/sign-in']);
      },
      error(data) {
        console.log('Error',data),
        self.invalid = true;
      },
  })}
}
