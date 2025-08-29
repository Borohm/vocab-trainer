import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeMots } from './liste-mots';

describe('ListeMots', () => {
  let component: ListeMots;
  let fixture: ComponentFixture<ListeMots>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListeMots]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeMots);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
