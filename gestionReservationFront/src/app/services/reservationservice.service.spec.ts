import { TestBed } from '@angular/core/testing';

import { ReservationserviceService } from './reservationservice.service';

describe('ReservationserviceService', () => {
  let service: ReservationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
