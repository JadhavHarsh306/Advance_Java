import React,{useState,useEffect} from 'react'
import ProductService from '../service/ProductService';
export default function ProductTabComponent() {
    const [prodarr,setprodarr]=useState([])
    const [searcharr,setsearcharr]=useState([])
    const [searchtxt,setsearch]=useState("");
    //initialization hook ---> ComponentDidMount
    useEffect(()=>{
        fetchdata();
    },[])
    useEffect(()=>{
        if(searchtxt===""){
            setsearcharr([...prodarr])
        }else{
            let newarr=prodarr.filter(prod=>prod.pname.includes(searchtxt));
            setsearcharr([...newarr])
        }
    },[prodarr])
    const fetchdata=()=>{
       ProductService.getAllProducts()
       .then((result)=>{
        setprodarr([...result.data])
       })
       .catch((err)=>{
        console.log(err)
       })
    }
    const deletedata=(pid)=>{
        ProductService.deleteProduct(pid)
        .then(()=>{
            fetchdata()
        })
        .catch((err)=>{
            console.log(err)
        })
    }
  return (
    <div>
        Search : <input type="text" name="search" id="search"
        value={searchtxt}
        onChange={(event)=>{setsearch(event.target.value)}}></input>

        <button type="button" name="add" id="add" value="add"
                className="btn btn-info">Add new Product</button>

        <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">expdate</th>
      <th scope="col">cid</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
    {searcharr.map(prod=>(
        <tr>
            <td>{prod.pid}</td>
            <td>{prod.pname}</td>
            <td>{prod.qty}</td>
            <td>{prod.price}</td>
            <td>{prod.ldtstr}</td>
            <td>{prod.cid}</td>
            <td>
                <button type="button" name="delete" id="delete" value="delete" className="btn btn-danger" onClick={()=>{deletedata(prod.pid)}}>Delete</button>&nbsp;&nbsp;&nbsp;

                <button type="button" name="edit" id="edit" value="edit"
                className="btn btn-primary">Edit</button>&nbsp;&nbsp;&nbsp;

                <button type="button" name="View" id="View" value="View"
                className="btn btn-success">View</button>
            </td>
           
    </tr>
    ))}
    
   
  </tbody>
</table>
    </div>
  )
}
