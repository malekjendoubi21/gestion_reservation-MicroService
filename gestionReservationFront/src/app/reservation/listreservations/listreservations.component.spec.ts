import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListreservationsComponent } from './listreservations.component';

describe('ListreservationsComponent', () => {
  let component: ListreservationsComponent;
  let fixture: ComponentFixture<ListreservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListreservationsComponent]
    });
    fixture = TestBed.createComponent(ListreservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
