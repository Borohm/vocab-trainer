import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { ListeMots } from './components/liste-mots/liste-mots';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'liste-mots', component: ListeMots }
];
