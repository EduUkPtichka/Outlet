package determent.outlet.decompose_core.root_decompose_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import determent.outlet.decompose_core.root_decompose.RootComponent
import determent.outlet.reg_block_decompose.RegComponent
import determent.outlet.reg_compose_ui.RegScreen

@Composable
fun RootContentScreen(
    content: RootComponent,
    modifier: Modifier = Modifier
) {
    Children(
        stack = content.stack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ){
        when (val child = it.instance){
            is RootComponent.Child.ChildRegComponent -> RegScreen()
        }
    }
}