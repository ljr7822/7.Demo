package com.example.a7demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 计算页面按钮
         */
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

        /**
         * 分享按钮
         */
        mbutton2.setOnClickListener {
            // 使用隐式跳转到某个页面
            Intent().apply {
                action = "ljr.fenxian.wechar"
                data = Uri.parse("content: 今天完成了Activity的跳转 很棒")
            }.also {
                // startActivity(it)
                startActivityForResult(it,456)
            }
        }
    }

    /**
     * 接收计算回调
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123){
            // 计算页面
            data?.getIntExtra("result",0).also {
                // 将结果赋值到textview上
                mResult.text = it.toString()
            }
        }else if (requestCode == 456){
            // 分享页面
            data?.getStringExtra("shareResult").also {
                // 弹出提升框
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        }
    }
}
