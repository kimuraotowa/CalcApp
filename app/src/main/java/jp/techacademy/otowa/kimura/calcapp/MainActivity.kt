package jp.techacademy.otowa.kimura.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //レイアウトxmlで定義されたEditText,Button検索
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val DivButton = findViewById<Button>(R.id.btn1)
        val mulButton = findViewById<Button>(R.id.btn2)
        val AddButton = findViewById<Button>(R.id.btn3)
        val SubButton = findViewById<Button>(R.id.btn4)

        //Buttonがクリックされたときの動作
        //EditTextを使って計算
        // Double型
        DivButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()

            //num1とnum2がどちらでもない場合
            if (num1 != null && num2 != null ) {
                val result = num1 / num2
                openResultActivity(result)
                //num1またはnum2がnullの場合またnum2が0の場合エラーメッセージ表示
            } else {
                showErrorMessage()
            }
        }

        mulButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()

            //num1とnum2がどちらでもない場合
            if (num1 != null && num2 != null ) {
                val result = num1 * num2
                openResultActivity(result)
                //num1またはnum2がnullの場合エラーメッセージ表示
            } else {
                showErrorMessage()
            }
        }

        AddButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()

            //num1とnum2がどちらでもない場合①動く
            if (num1 != null && num2 != null ) {
                //①
                val result = num1 + num2
                openResultActivity(result)
            //num1またはnum2がnullの場合エラーメッセージ表示
            } else {
                showErrorMessage()
            }
        }

        SubButton.setOnClickListener {
            val num1 = et1.text.toString().toDoubleOrNull()
            val num2 = et2.text.toString().toDoubleOrNull()

            //num1とnum2がどちらでもないかつnum2は0.0でもない場合
            if (num1 != null && num2 != null ) {
                val result = num1 - num2
                openResultActivity(result)
            //num1またはnum2がnullの場合またnum2が0の場合エラーメッセージ表示
            } else {
                showErrorMessage()
            }
        }
    }

    //openResultActivity　→　計算結果をSecondActivityに送信するメソッド
    private fun openResultActivity(result: Double) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("RESULT", result)
        }
        startActivity(intent)
    }

    //showErrorMessageプライベート関数
    private fun showErrorMessage() {
        //ダイアログ作成
        AlertDialog.Builder(this)
            .setTitle("エラー")
            .setMessage("数値を入力してください")
            .setPositiveButton("OK", null)
            .show()
    }
}
