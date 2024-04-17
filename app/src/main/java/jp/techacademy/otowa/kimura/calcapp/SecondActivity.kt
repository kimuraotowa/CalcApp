package jp.techacademy.otowa.kimura.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val result = intent.getDoubleExtra("RESULT", 0.0)
        val resultTextView = findViewById<TextView>(R.id.tV2)
        resultTextView.text="結果:$result"
    }
}