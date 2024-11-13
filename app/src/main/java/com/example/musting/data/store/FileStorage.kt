package com.example.musting.data.store

import android.content.Context
import android.os.Environment
import java.io.*

class FileStorage(private val context: Context) {

    fun publicFile(dir: String, fileName: String): File {
        val publicDir = Environment.getExternalStoragePublicDirectory(dir)
        return File(publicDir, fileName)
    }

    fun file(dir: String, fileName: String): File {
        val directory = context.getExternalFilesDir(dir)
        return File(directory, fileName)
    }

    fun writeFile(file: File, rows: List<String>): Boolean {
        return try {
            val outputStream = FileOutputStream(file)
            for (raw in rows) {
                outputStream.write((raw + "\n").toByteArray())
            }
            outputStream.close()
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun readFile(file: File): List<String> {
        val lines = mutableListOf<String>()
        try {
            val inputStream = FileInputStream(file)
            val reader = BufferedReader(InputStreamReader(inputStream))

            var line: String?
            while (reader.readLine().also { line = it } != null) {
                lines.add(line!!)
            }

            reader.close()
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return lines
    }
}
