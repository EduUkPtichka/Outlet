package determent.outlet.reg_block_decompose.model

import kotlin.jvm.JvmInline

@JvmInline
value class PhoneNumber(val value: String)

@JvmInline
value class EmailPerson(val value: String)

data class RegModelScreen(
    val phoneNumber: PhoneNumber,
    val emailPerson: EmailPerson,
)

