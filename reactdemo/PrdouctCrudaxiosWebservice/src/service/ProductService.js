import axios from 'axios';
var baseUrl="http://localhost:9090/SpringRestWebService/product/";


class ProductService{
    getAllProducts(){
      return axios.get(baseUrl+"products")
    }
    addProduct(p){
        //let myheader={"content-type":"application/json","Autherization":"Bearer <jsontoken>"};
        let myheader={"content-type":"application/json"};
        return axios.post(baseUrl+"products/"+p.pid,p,{headers:myheader});
    }
    deleteProduct(pid){
        return axios.delete(baseUrl+"products/"+pid);
    }
}

export default new ProductService()