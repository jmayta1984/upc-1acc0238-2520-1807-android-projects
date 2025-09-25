package pe.edu.upc.easyshop.features.auth.domain.model

data class User(
    val name: String,
    val image: String,
    val email: String,
    val token: String
)
