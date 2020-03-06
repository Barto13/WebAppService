import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../product';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';
import { ProductListComponent } from '../product-list/product-list.component';


@Component({
  selector: 'app-payu',
  templateUrl: './payu.component.html',
  styleUrls: ['./payu.component.css']
})
export class PayuComponent implements OnInit {

  id: number;
  product: Product;

  public payuform: any = {};
  disablePaymentButton: boolean = true;
  constructor(private http: HttpClient, private route: ActivatedRoute,private router: Router,
    private productService: ProductService) { }


  confirmPayment() {
    const paymentPayload = {
      email: this.payuform.email,
      name: this.payuform.firstname,
      phone: this.payuform.phone,
      productInfo: this.payuform.productinfo,
      amount: this.payuform.amount
    }
    return this.http.post<any>('http://localhost:8080/payment/payment-details', paymentPayload)
    .subscribe( data => {
      console.log(data);
      this.payuform.txnid = data.txnId;
      this.payuform.surl = data.sUrl;
      this.payuform.furl = data.fUrl;
      this.payuform.key = data.key;
      this.payuform.hash = data.hash;
      this.payuform.txnid = data.txnId;
        this.disablePaymentButton = false;
    }, error1 => {
        console.log(error1);
      })
  }

  ngOnInit() {
    // this.product = new Product();

    // this.id = this.route.snapshot.params['id'];
    
    // this.productService.getProduct(this.id)
    //   .subscribe(data => {
    //     console.log(data)
    //     this.product = data;
    //   }, error => console.log(error));
  }


}