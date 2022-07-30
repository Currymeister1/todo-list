import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskcreatorComponent } from './taskcreator.component';

describe('TaskcreatorComponent', () => {
  let component: TaskcreatorComponent;
  let fixture: ComponentFixture<TaskcreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskcreatorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskcreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
