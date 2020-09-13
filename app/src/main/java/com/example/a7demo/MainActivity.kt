package com.example.a7demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbutton1.setOnClickListener {
            // 跳转到下一个页面并且计算
            // 创建Intent
            Intent().apply {
                // 设置值
                putExtra("first", mFirst.text.toString().toInt())
                putExtra("second", mTwo.text.toString().toInt())

                // 设置从那个页面跳转到那个页面
                setClass(this@MainActivity, DetailActivity::class.java)

                // 跳转，带参数的
                startActivityForResult(this, 123)
            }
        }
    }

    /**
     * 接收回调
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123){
            data?.getIntExtra("result",0).also {
                // 将结果赋值到textview上
                mResult.text = it.toString()
            }
        }
    }
}
