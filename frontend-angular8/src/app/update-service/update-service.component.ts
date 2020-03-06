import { Component, OnInit } from '@angular/core';
import { Service } from '../service';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrls: ['./update-service.component.css']
})
export class UpdateServiceComponent implements OnInit {

  id: number;
  service: Service;

  constructor(private route: ActivatedRoute,private router: Router,
    private serviceService: ServiceService) { }

  ngOnInit() {
    this.service = new Service();

    this.id = this.route.snapshot.params['id'];
    
    this.serviceService.getService(this.id)
      .subscribe(data => {
        this.service = data;
      });
  }

  updateService() {
    this.serviceService.updateService(this.id, this.service)
      .subscribe(data => console.log(data), error => console.log(error));
    this.service = new Service();
    this.gotoList();
  }

  onSubmit() {
    this.updateService();    
  }

  gotoList() {
    this.router.navigate(['/services']);
  }
}