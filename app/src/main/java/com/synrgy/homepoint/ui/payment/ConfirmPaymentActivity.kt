package com.synrgy.homepoint.ui.payment

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityConfirmPaymentBinding
import com.synrgy.homepoint.databinding.ActivityPaymentBinding
import okhttp3.internal.wait

class ConfirmPaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmPaymentBinding
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imgPreviewSample.setOnClickListener {
                val directoryIntent = Intent(Intent.ACTION_PICK)
                directoryIntent.type = "image/"
                startForDirectory.launch(directoryIntent)
            }
            btnReuploadImage.setOnClickListener {
                val directoryIntent = Intent(Intent.ACTION_PICK)
                directoryIntent.type = "image/"
                startForDirectory.launch(directoryIntent)
            }
        }

        binding.btnAfterConfirmPayment.setOnClickListener {
            dialogConfirm()
        }
    }

       private var startForDirectory =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.apply {
                    imgPreviewSample.visibility = View.GONE
                    imagePreview.visibility = View.VISIBLE
                    imageUri = result.data?.data
                    imagePreview.setImageURI(imageUri)
                    btnReuploadImage.visibility = View.VISIBLE
                    btnBeforeConfirmPayment.visibility = View.GONE
                    btnAfterConfirmPayment.visibility = View.VISIBLE
                }
            }
        }

    private fun dialogConfirm(){
        val dialogBinding = LayoutInflater.from(this).inflate(R.layout.dialog_confirm_payment, null, false)
        val dialogBuilder = Dialog(this)
        dialogBuilder.setContentView(dialogBinding)

        dialogBuilder.setCancelable(true)
        dialogBuilder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBuilder.show()

        dialogBinding.findViewById<TextView>(R.id.btn_confirm_dialog).setOnClickListener {
            Toast.makeText(this, "Confirm Payment", Toast.LENGTH_LONG).show()
            dialogBuilder.dismiss()
        }
        dialogBinding.findViewById<TextView>(R.id.btn_see_again).setOnClickListener {
            dialogBuilder.dismiss()
        }
        dialogBuilder.show()
    }

}