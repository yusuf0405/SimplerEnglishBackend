package english.simpler.joseph

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import english.simpler.joseph.plugins.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()

    }.start(wait = true)
}