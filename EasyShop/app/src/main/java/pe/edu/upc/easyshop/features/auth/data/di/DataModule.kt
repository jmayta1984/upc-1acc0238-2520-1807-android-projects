package pe.edu.upc.easyshop.features.auth.data.di

import pe.edu.upc.easyshop.features.auth.data.remote.services.AuthService
import pe.edu.upc.easyshop.features.auth.data.repositories.AuthRepositoryImpl
import pe.edu.upc.easyshop.features.auth.domain.repositories.AuthRepository
import pe.edu.upc.easyshop.features.home.data.di.DataModule.getRetrofit

object DataModule {

    fun getAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(getAuthService())
    }

    fun getAuthService(): AuthService {
        return getRetrofit().create(AuthService::class.java)
    }
}