package pe.edu.upc.easyshop.features.home.data.remote.services

import pe.edu.upc.easyshop.features.home.data.remote.model.ProductDto
import pe.edu.upc.easyshop.features.home.data.remote.model.ProductsWrapperDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductsWrapperDto>


    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductDto>
}