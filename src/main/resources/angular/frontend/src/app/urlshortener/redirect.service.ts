import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RedirectService {

  url = 'http://localhost:8080/'; // api rest fake


  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
    // Obtem todos os carros
    redirect(): Observable<any> {
      return this.httpClient.get(this.url)

    }
}
