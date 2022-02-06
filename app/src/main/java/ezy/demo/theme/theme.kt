package ezy.demo.theme

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.lifecycle.MutableLiveData

data class Theme(
    val content: Int,
    val background: Int,
)

object Themes {
    val Default = Theme(Color.RED, Color.GRAY)
    val Day = Theme(Color.BLACK, Color.WHITE)
    val Night = Theme(Color.MAGENTA, Color.BLACK)
}

object AppTheme {
    val background = MutableLiveData<ColorStateList>()
    val content = MutableLiveData<ColorStateList>()

    init {
        update(Themes.Default)
    }

    fun update(theme: Theme) {
        background.value = ColorStateList.valueOf(theme.background)
        content.value = ColorStateList.valueOf(theme.content)
    }
}

@SuppressLint("RestrictedApi")
@BindingMethods(
    BindingMethod(type = ImageView::class, attribute = "tint", method = "setImageTintList")
)
object ThemeAdapter {
    @BindingAdapter("background")
    @JvmStatic
    fun adaptBackground(view: View, value: ColorStateList?) {
        view.setBackgroundColor(Color.WHITE)
        view.backgroundTintList = value
    }
    @BindingAdapter("drawableTint")
    @JvmStatic
    fun adaptDrawableTint(view: TextView, value: ColorStateList?) {
        if (view is AppCompatTextView) {
            view.supportCompoundDrawablesTintList = value
        }
    }

    @BindingAdapter("android:progressBackgroundTint")
    @JvmStatic
    fun adaptProgressBackgroundTint(view: SeekBar, value: ColorStateList?) {
        view.progressBackgroundTintList = value
    }
}