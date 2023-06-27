import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DetailComponent } from '../detail/detail.component';
import { FormControl } from '@angular/forms';
import { ViewService } from '../services/view.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.scss'],
})
export class LogComponent implements OnInit {

  components = new FormControl('');
  componentList: string[] = [];

  displayedColumns = ['timestamp', 'entityName', 'traceId', 'errorMessage', 'message'];
  dataSource = [];

  traceId: string = "";
  message: string = "";

  constructor(
    private matSnackBar: MatSnackBar,
    private dialog: MatDialog,
    private service: ViewService
  ) { }

  ngOnInit(): void {
    this.onLoadComponents();
    this.onFilterLogs();
  }

  openModal(data: string): void {
    this.dialog.open(DetailComponent, {
      width: '750px',
      height: '100vh',
      data: data,
      position: {
        right: '0px'
      }
    });
  }

  onLoadComponents(): void {
    this.service.components().subscribe({
      next: response => this.componentList = response,
      error: err => console.error(err),
      complete: () => this.onMessage('Carga de componentes completado')
    });
  }

  onSyncLogs(): void {
    let data = (!!this.components.value) ? this.components.value : [];
    this.service.syncLogs(data).subscribe({
      next: response => (!response) ? this.onMessage('Sincronización no se completado') : '',
      error: err => console.error(err),
      complete: () => {
        this.onMessage('Sincronización de logs completado');
        this.onFilterLogs();
      }
    });
  }

  onFilterLogs(): void {
    this.service.filterLogs(this.traceId, this.message).subscribe({
      next: response => this.dataSource = response,
      error: err => console.error(err),
      complete: () => this.onMessage('Listado de logs completado')
    });
  }

  onMessage(textMessage: string) {
    this.matSnackBar.open(
      textMessage,
      'Cerrar',
      { duration: 3000, verticalPosition: 'bottom', horizontalPosition: 'center' }
    );
  }

}

