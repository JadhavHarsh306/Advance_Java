import React,{useState} from 'react'
import {useNavigate} from 'react-router-dom';
import ProductService from '../service/ProductService'
export default function ProductFormcomponent() {
    const [formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:"",ldtstr:"",cid:""})
    const [formerrors,setformerros]=useState({});
    const navigate=useNavigate();
    const handlechange=(event)=>{
        let name=event.target.name;
   setformdetails({...formdetails,[name]:event.target.value})
    }
    const submitform=(event)=>{
        event.preventDefault(); // stop refresh page action of submit button
        if(formdetails.pid==="" || formdetails.pname==="" || formdetails.qty==="" || formdetails.price==="" || formdetails.expdate==="" || formdetails.cid===""){
           alert("pls fill all details")
        }else{
            console.log(formdetails)
            ProductService.addProduct(formdetails)
            .then((result)=>{
                console.log(result);
                navigate("/products")
                
            })
            .catch((err)=>{
              console.log(err)
            })
        }
    }
  return (
    <div>
         <form onSubmit={submitform}>
            <div className="form-group">
                <label htmlFor="pid">Product Id</label>
                <input type="text" className="form-control" id="pid" name='pid'
                onChange={handlechange}
                value={formdetails.pid}/>
                <p>{formerrors.pid}</p>
            </div>
            <div className="form-group">
                <label htmlFor="pname">Product Name</label>
                <input type="text" className="form-control" id="pname" name='pname'
                onChange={handlechange}
                value={formdetails.pname}/>
            </div>
            <div className="form-group">
                <label htmlFor="qty">Quantity</label>
                <input type="text" className="form-control" id="qty" name='qty'
                onChange={handlechange}
                value={formdetails.qty}/>
            </div>
            <div className="form-group">
                <label htmlFor="price">Product Price</label>
                <input type="text" className="form-control" id="price" name='price'
                onChange={handlechange}
                value={formdetails.price}/>
            </div>
            <div className="form-group">
                <label htmlFor="expdate">Expiry Date</label>
                <input type="text" className="form-control" id="ldtstr" name='ldtstr'
                onChange={handlechange}
                value={formdetails.ldtstr}/>
            </div>
            <div className="form-group">
                <label htmlFor="cid">Category Id</label>
                <input type="text" className="form-control" id="cid" name='cid'
                onChange={handlechange}
                value={formdetails.cid}/>
            </div>
           
  <button type="submit" className="btn btn-primary">Submit</button>
</form>
    </div>
  )
}
