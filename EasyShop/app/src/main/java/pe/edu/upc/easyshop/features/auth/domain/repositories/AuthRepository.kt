package pe.edu.upc.easyshop.features.auth.domain.repositories

import pe.edu.upc.easyshop.features.auth.domain.model.User

interface AuthRepository {

    suspend fun login(username: String, password: String): User?

}