import { TestBed } from '@angular/core/testing';

import { CapitalizacionService } from './capitalizacion.service';

describe('CapitalizacionService', () => {
  let service: CapitalizacionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CapitalizacionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
