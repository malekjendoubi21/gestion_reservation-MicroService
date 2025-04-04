import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddreservationsComponent } from './addreservations.component';

describe('AddreservationsComponent', () => {
  let component: AddreservationsComponent;
  let fixture: ComponentFixture<AddreservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddreservationsComponent]
    });
    fixture = TestBed.createComponent(AddreservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
