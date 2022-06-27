import { TestBed } from '@angular/core/testing';

import { TipoInteresService } from './tipo-interes.service';

describe('TipoInteresService', () => {
  let service: TipoInteresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoInteresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
