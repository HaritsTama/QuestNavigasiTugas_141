package com.example.navigasipraktikum.view



import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier



@Composable
fun FormulirP(modifier: Modifier
) {
    var textNamaLengkap by remember { mutableStateOf("") }
    var textAlamatP by remember { mutableStateOf("") }
    var textKelamin by remember { mutableStateOf("") }
    var textKawin by remember { mutableStateOf("") }

    var namal by remember { mutableStateOf("") }

}