package determent.outlet.reg_compose_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import determent.outlet.common_resource.MR
import dev.icerock.moko.resources.compose.colorResource

@Composable
internal fun RegSwitchButton(
    items: List<String>,
    selectedIndex: Int,
    onClick: (Int) -> Unit,
) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(22.dp))
            .border(2.dp, colorResource(MR.colors.grey3), RoundedCornerShape(22.dp))
            .height(60.dp)
            .fillMaxWidth()
            .background(colorResource(MR.colors.white_background_L1)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEachIndexed { index, items ->

            val isSelected: Boolean = selectedIndex == index

            TextButton(
                onClick = { onClick(index) },
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .fillMaxHeight()
                    .weight(1f)
                    .then(
                        if (isSelected) Modifier.background(colorResource(MR.colors.grey3))
                        else Modifier.background(colorResource(MR.colors.white_background_L1))
                    ),
                enabled = !isSelected
            ) {
                Text(
                    text = items
                )
            }
        }
    }
}
