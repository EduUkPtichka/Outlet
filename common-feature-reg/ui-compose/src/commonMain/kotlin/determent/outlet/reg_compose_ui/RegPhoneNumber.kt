package determent.outlet.reg_compose_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import determent.outlet.common_resource.MR
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.painterResource

@Composable
internal fun RegPhoneNumber(
    onPhoneNumberChanged: (String) -> Unit,
    phoneNumber: String,
) {
    OutlinedTextField(
        value = phoneNumber,
        onValueChange = {
            onPhoneNumberChanged(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(22.dp))
            .border(2.dp, colorResource(MR.colors.grey3), RoundedCornerShape(22.dp))
            .background(colorResource(MR.colors.white_background_L1)),
        leadingIcon = {
            PhoneNumberLeadingIcon()
        },
    )
}


@Composable
private fun PhoneNumberLeadingIcon(

) {

    Box(
        modifier = Modifier
            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
            .height(50.dp)
            .width(50.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(colorResource(MR.colors.grey3)),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(MR.images.kyrgyzstan_flag),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
        )
    }
}
