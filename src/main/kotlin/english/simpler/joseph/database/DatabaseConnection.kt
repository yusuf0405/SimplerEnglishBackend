package english.simpler.joseph.database

import org.jetbrains.exposed.sql.Database

object DatabaseConnection {
    val database = Database.connect(
        url = "postgres://ec2-52-51-3-22.eu-west-1.compute.amazonaws.com:5432/dfs410af67cuj1",
        driver ="heroku pg:psql postgresql-regular-89647 --app simpler-english-backend",
        user = "rzkapbwoimoztn",
        password = "c446e4420c01ea9745daf6e81e77b039e1435b67d942713c61bfabd99f745054"
    )
}