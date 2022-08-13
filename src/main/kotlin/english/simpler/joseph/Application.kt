package english.simpler.joseph

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import english.simpler.joseph.database.DatabaseConnection
import english.simpler.joseph.features.login.configureLoginRouting
import english.simpler.joseph.features.register.configureRegisterRouting
import english.simpler.joseph.plugins.configureRouting
import english.simpler.joseph.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(DatabaseConnection.hikari())
    Database.connect(dataSource)

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureSerialization()
        configureLoginRouting()
        configureRegisterRouting()
    }.start(wait = true)
}