package pe.edu.upc.easyshop.features.home.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import pe.edu.upc.easyshop.features.home.data.local.model.ProductEntity

@Dao
interface ProductDao {

    @Insert
    suspend fun insert(vararg entities: ProductEntity)

    @Delete
    suspend fun delete(vararg entities: ProductEntity)

    @Update
    suspend fun update(vararg entities: ProductEntity)

    @Query("select * from products")
    suspend fun fetchAll(): List<ProductEntity>
}