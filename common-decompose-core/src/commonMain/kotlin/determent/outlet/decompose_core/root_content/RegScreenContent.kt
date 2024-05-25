package determent.outlet.decompose_core.root_content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import determent.outlet.reg_block_decompose.RegComponent
import determent.outlet.reg_compose_ui.RegScreen


@Composable
fun RegScreenContent(
    component: RegComponent,
    modifier: Modifier = Modifier,
){
    val model by component.models.collectAsState()

    RegScreen()

}