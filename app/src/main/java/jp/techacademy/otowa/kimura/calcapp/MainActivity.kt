package jp.techacademy.otowa.kimura.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //レイアウトxmlで定義されたEditText,Button検索
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val AddButton = findViewById<Button>(R.id.btn3)
        val mulButton = findViewById<Button>(R.id.btn2)
        val DivButton = findViewById<Button>(R.id.btn1)
        val SubButton = findViewById<Button>(R.id.btn4)

        //Buttonがクリックされたときの動作
        //EditTextを使って計算
        // Double型
        //?:0.0 EditTextに入力されてない場合 0.0を使う
        AddButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = et2.text.toString().toDoubleOrNull() ?: 0.0
            val result = num1 + num2
            openResultActivity(result)
        }

        mulButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = et2.text.toString().toDoubleOrNull() ?: 0.0
            val result = num1 * num2
            openResultActivity(result)
        }

        DivButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = et2.text.toString().toDoubleOrNull() ?: 0.0
            val result = num1 / num2
            openResultActivity(result)
        }

        SubButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = et2.text.toString().toDoubleOrNull() ?: 0.0
            val result = num1 - num2
            openResultActivity(result)
        }
    }
    //openResultActivity　→　計算結果をSecondActivityに送信するメソッド
    private fun openResultActivity(result: Double) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("RESULT", result)
        startActivity(intent)
    }
}
