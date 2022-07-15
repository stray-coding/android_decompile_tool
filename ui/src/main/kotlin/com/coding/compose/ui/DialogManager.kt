package com.coding.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.coding.compose.ui.aab.AABDialog
import com.coding.compose.ui.adb.ADBDialog
import com.coding.compose.ui.dec.DecDialog
import com.coding.compose.ui.dex.DexDialog
import com.coding.compose.ui.sign.SignDialog

@OptIn(ExperimentalUnitApi::class)
@Composable
fun showDialog(type: DialogType) {
    val dec_show = remember { mutableStateOf(false) }
    val dex_show = remember { mutableStateOf(false) }
    val sign_show = remember { mutableStateOf(false) }
    val aab_show = remember { mutableStateOf(false) }
    val adb_show = remember { mutableStateOf(false) }
    DecDialog(dec_show)
    DexDialog(dex_show)
    SignDialog(sign_show)
    AABDialog(aab_show)
    ADBDialog(adb_show)
    when (type) {
        DialogType.DEC -> dec_show.value = true
        DialogType.DEX -> dex_show.value = true
        DialogType.SIGN -> sign_show.value = true
        DialogType.AAB -> aab_show.value = true
        DialogType.ADB -> adb_show.value = true
    }

}

enum class DialogType {
    DEC, DEX, SIGN, AAB, ADB
}