import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent {

  public log: any;

  constructor(
    private sanitizer: DomSanitizer,
    public dialogRef: MatDialogRef<DetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
    this.log = data
  }

  formatErrorStack(error: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml('ErrorStack: ' + error.replaceAll('at ', '<br>at&nbsp;'));
  }

  formatMessage(message: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml('Message: <br>' + message.replaceAll('at ', '<br>at&nbsp;'));
  }
}
