import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailReservationsComponent } from './detail-reservations.component';

describe('DetailReservationsComponent', () => {
  let component: DetailReservationsComponent;
  let fixture: ComponentFixture<DetailReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailReservationsComponent]
    });
    fixture = TestBed.createComponent(DetailReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
