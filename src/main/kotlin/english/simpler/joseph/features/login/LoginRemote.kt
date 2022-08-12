package english.simpler.joseph.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginReceiveRemote(
    val login: String,
    val password: String
)

@kotlinx.serialization.Serializable
data class LoginResponseRemote(
    val token: String
)