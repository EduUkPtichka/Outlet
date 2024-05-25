package determent.outlet.reg_compose_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import determent.outlet.common_resource.MR
import dev.icerock.moko.resources.compose.colorResource

@Composable
fun RegScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(MR.colors.white_background_L1)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val items = remember {
            listOf("Почта", "Телефон")
        }

        var selectedIndex by remember {
            mutableIntStateOf(0)
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        Text(text = "Регистрация")

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        RegSwitchButton(
            items = items,
            selectedIndex = selectedIndex,
            onClick = { index ->
                selectedIndex = index
            }
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        RegTextFieldStrategy(
            component1 = {
                RegPhoneNumber(onPhoneNumberChanged = {}, phoneNumber = "+996")
            },
            component2 = { RegPhoneNumber(onPhoneNumberChanged = {}, phoneNumber = "+996") },
            selectedIndex = 0
        )
    }

}


