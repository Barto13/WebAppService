import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private baseUrl = 'http://localhost:8080/services';

  constructor(private http: HttpClient) { }

  getService(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createService(Service: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, Service);
  }

  updateService(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteService(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getServicesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}