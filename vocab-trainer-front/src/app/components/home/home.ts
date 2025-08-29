import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home {
  router = inject(Router);

  goToListeMots() {
    this.router.navigate(['/liste-mots']);
  }
}
