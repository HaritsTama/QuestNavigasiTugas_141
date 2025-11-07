package com.example.navigasipraktikum

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasipraktikum.view.FormulirP
import com.example.navigasipraktikum.view.HalamanUtama
import com.example.navigasipraktikum.view.TampilData

enum class HalamanNavigasi {
    Beranda,
    Formulir,
    TampilData
}

@Composable
fun NavigasiApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HalamanNavigasi.Beranda.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = HalamanNavigasi.Beranda.name) {
                HalamanUtama(
                    onSubmitClick = {
                        navController.navigate(HalamanNavigasi.TampilData.name)
                    }
                )
            }

            composable(route = HalamanNavigasi.TampilData.name) {
                TampilData(
                    namaLengkap = namaLengkap,
                    jenisKelamin = jenisKelamin,
                    statusPerkawinan = statusPerkawinan,
                    alamat = alamat,
                    onBerandaClick = {
                        navController.popBackStack(
                            HalamanNavigasi.Beranda.name,
                            inclusive = false
                        )
                    },
                    onFormulirClick = {
                        navController.navigate(HalamanNavigasi.Formulir.name)
                    }
                )
            }

            composable(route = HalamanNavigasi.Formulir.name) {
                FormulirP(
                    modifier = Modifier,
                    onSubmitClick = { nama, kelamin, kawin, alamatInput ->
                        // Simpan data
                        namaLengkap = nama
                        jenisKelamin = kelamin
                        statusPerkawinan = kawin
                        alamat = alamatInput

                        // Navigate ke halaman tampil data
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}