package com.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coding.dec.ADT
import com.coding.dec.utils.Suffix
import com.coding.ui.FileChooser
import com.compose.base.Button
import com.compose.base.CheckBox
import com.compose.base.Dialog
import javax.swing.JFileChooser


@Composable
fun DecDialog(show: MutableState<Boolean>) {
    Dialog(title = "dec", state = show) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val ignoreDex = remember { mutableStateOf(false) }
            val ignoreResource = remember { mutableStateOf(false) }
            CheckBox("ignore dex", ignoreDex)
            CheckBox("ignore resource", ignoreResource)
            Button("decompile") {
                FileChooser.newInstance(
                    window,
                    JFileChooser.FILES_ONLY,
                    "choose apk",
                    Suffix.APK,
                    object : FileChooser.OnSelectListener {
                        override fun onSelected(path: String) {
                            ADT.decompile(path, ignoreDex.value, ignoreResource.value)
                        }
                    })
            }
        }
    }
}
