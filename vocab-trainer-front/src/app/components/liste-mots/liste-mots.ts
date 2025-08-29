import { HttpClient } from '@angular/common/http';
import { Component, HostListener, inject, ViewChild } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Word } from '../../models/word';
import { AgGridModule, AgGridAngular } from 'ag-grid-angular';
import { colorSchemeDark, themeAlpine, type ColDef } from 'ag-grid-community'; 
import { WordTypeLabels } from '../../models/wordType';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-liste-mots',
  imports: [AgGridModule],
  templateUrl: './liste-mots.html',
  styleUrl: './liste-mots.scss'
})
export class ListeMots {
  http = inject(HttpClient);
  listeMots: Word[] = [];
  colDefs: ColDef[] = [
    { field: 'kanji' },
    { field: 'kana', sort: 'asc' },
    { field: 'translation', headerName: 'Traduction' },
    { field: 'example' },
    { field: 'exampleTranslation', headerName: 'Traduction de l\'exemple' },
    { field: 'type', valueFormatter: (params) => WordTypeLabels[params.value] ?? params.value},
    { field: 'level'}
  ]
  defaultColDef: ColDef = {
    resizable: false,
    suppressMovable: true,
    sortable: true,
    filter: true
  };
  theme = themeAlpine.withPart(colorSchemeDark);
  @ViewChild('agGrid') grid!: AgGridAngular;

  constructor(private toastr: ToastrService) {}

  ngOnInit() {
    this.getListeMots();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.resizeColumns();
  }

  getListeMots() {
    return this.http.get<Word[]>(environment.apiUrl + '/word')
      .subscribe({
        next: (response) => {
          this.listeMots = response;
          this.toastr.success('Liste des mots mise à jour');
        },
        error: () => {
          this.toastr.error('Une erreur est survenue');
        }
      });
  }

  majMots() {
    this.http.get(environment.apiUrl + '/word/import')
      .subscribe({
        next: () => {
          this.getListeMots();
        },
        error: () => {
          this.toastr.error('Une erreur est survenue');
        }
      });
  }

  resizeColumns() {
    this.grid.api.sizeColumnsToFit();
  }
}
