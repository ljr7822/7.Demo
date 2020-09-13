package com.example.a7demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 获取传递的intent参数
        val first = intent.getIntExtra("first", 0)
        val second = intent.getIntExtra("second", 0)

        /**
         * 实现按钮点击事件完成计算
         */
        zzjsButton.setOnClickListener {
            // 开始计算
            val result = first + second
            // 将结果回调给上一个页面
            Intent().apply {
                putExtra("result",result)
            }.also {
                setResult(0,it)
            }
            // 返回上一个页面
            finish()
        }

        /**
         * 打电话咨询计算
         */
        ddhzxButton.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:18289816889")
            }.also {
                startActivity(it)
            }
        }
    }
}