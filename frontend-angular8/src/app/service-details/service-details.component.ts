import { Service } from '../service';
import { Component, OnInit, Input } from '@angular/core';
import { ServiceService } from '../service.service';
import { ServiceListComponent } from '../service-list/service-list.component';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-service-details',
  templateUrl: './service-details.component.html',
  styleUrls: ['./service-details.component.css']
})
export class ServiceDetailsComponent implements OnInit {

  id: number;
  service: Service;

  constructor(private route: ActivatedRoute,private router: Router, private serviceService: ServiceService) { }

  ngOnInit() {
    this.service = new Service();

    this.id = this.route.snapshot.params['id'];
    
    this.serviceService.getService(this.id)
      .subscribe(data => {
        this.service = data;
      });
  }

  list(){
    this.router.navigate(['services']);
  }
}
