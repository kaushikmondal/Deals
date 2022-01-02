
1.Create Deal:
API:/create-deal
Method: POST
Headers: 
Content-type: application/json
Body:
{
    "dealName":"String"//Mandotory, name of deal
    "dealDesc":"String" //Mandatory, description of deal
    "dealType":"String"//Mandatory, type of deal, ex: BOGO
    "sellerId": number // Mandatory, id of the seller creating the deal
    "productId: number //Mandatory, sku of the product against which deal is being created
}
