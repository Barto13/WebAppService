import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { ServiceService } from "../service.service";
import { Service } from "../service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  services: Observable<Service[]>;

  constructor(private serviceService: ServiceService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.services = this.serviceService.getServicesList();
  }

  deleteService(id: number) {
    this.serviceService.deleteService(id)
      .subscribe(
        data => {
          this.reloadData();
        });
  }

  serviceDetails(id: number){
    this.router.navigate(['Service-details', id]);
  }

  updateService(id: number){
    this.router.navigate(['Service-update', id]);
  }

  ShowOnMap(id: number){
    this.router.navigate(['Service-update', id]);
  }
}