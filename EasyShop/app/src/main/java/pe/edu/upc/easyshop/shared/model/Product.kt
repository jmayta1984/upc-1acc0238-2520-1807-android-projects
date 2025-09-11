package pe.edu.upc.easyshop.shared.model

data class Product(
    val name: String,
    val price: Double,
    val image: String
)

val products = listOf(
    Product(
        "T-shirt",
        price = 99.9,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    ),
    Product(
        "T-shirt",
        price = 99.9,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    ),
    Product(
        "T-shirt",
        price = 99.9,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    )
)
