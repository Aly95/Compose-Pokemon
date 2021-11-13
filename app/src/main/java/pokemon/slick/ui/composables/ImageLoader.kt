package pokemon.slick.ui.composables

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import pokemon.slick.utils.context
import pokemon.slick.utils.rememberedStateOf

@Composable
fun ImageLoader(url: String): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = rememberedStateOf(null)

    Glide.with(context())
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })
    return bitmapState
}