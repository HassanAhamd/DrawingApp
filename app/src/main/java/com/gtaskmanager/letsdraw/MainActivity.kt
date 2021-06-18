package com.gtaskmanager.letsdraw


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.gtaskmanager.letsdraw.databinding.ActivityMainBinding
import petrov.kristiyan.colorpicker.ColorPicker

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

       setupButtons()

    }

    @SuppressLint("ShowToast")
    private fun setupButtons() {

        mBinding.colorpicker.setOnClickListener {
            val colorpicker = ColorPicker(this)
            colorpicker.setOnFastChooseColorListener(object: ColorPicker.OnFastChooseColorListener{
                override fun setOnFastChooseColorListener(position: Int, color: Int) {
                    mBinding.dvDrawView.setColor(color)
                }

                override fun onCancel() {
                   colorpicker.dismissDialog()
                }

            })
                .disableDefaultButtons(true)
                .setColumns(5)
                .setRoundColorButton(true)
                .show()
        }

        mBinding.undoLastPaint.setOnClickListener {
            mBinding.dvDrawView.undo()
           Toast.makeText(this,"Undo Sucessfully",Toast.LENGTH_SHORT).show()
        }

        mBinding.reundoLastPaint.setOnClickListener {
            mBinding.dvDrawView.redo()
            Toast.makeText(this,"Re-Undo Sucessfully",Toast.LENGTH_SHORT).show()
        }

        }
    }