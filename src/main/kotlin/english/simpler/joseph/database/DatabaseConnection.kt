package english.simpler.joseph.database

import com.zaxxer.hikari.HikariConfig
import org.jetbrains.exposed.sql.Database
import java.net.URI

object DatabaseConnection {
//    val database = Database.connect(
//        url = "postgres://ec2-52-51-3-22.eu-west-1.compute.amazonaws.com:5432/dfs410af67cuj1",
//        driver = "heroku pg:psql postgresql-regular-89647 --app simpler-english-backend",
//        user = "rzkapbwoimoztn",
//        password = "c446e4420c01ea9745daf6e81e77b039e1435b67d942713c61bfabd99f745054"
//    )

    fun hikari(): HikariConfig {
        val config = HikariConfig()
        config.driverClassName = System.getenv("JDBC_DRIVER")
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        val uri = URI(System.getenv("DATABASE_URL"))
        val username = uri.userInfo.split(":").toTypedArray()[0]
        val password = uri.userInfo.split(":").toTypedArray()[1]
        config.jdbcUrl =
            "jdbc:postgresql://" + uri.host + ":" + uri.port + uri.path + "?ssl=require" +
                    "user$username&password$password"
        config.validate()
        return config
    }
}