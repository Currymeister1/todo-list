import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskeditorComponent } from './taskeditor.component';

describe('TaskeditorComponent', () => {
  let component: TaskeditorComponent;
  let fixture: ComponentFixture<TaskeditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskeditorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskeditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
