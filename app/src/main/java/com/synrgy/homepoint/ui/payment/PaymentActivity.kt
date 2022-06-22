package com.synrgy.homepoint.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.synrgy.homepoint.R
import com.synrgy.homepoint.databinding.ActivityPaymentBinding
import com.synrgy.homepoint.ui.home.DataSource
import com.synrgy.homepoint.ui.login.ForgetPassActivity

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private var listDelivery: ArrayList<Delivery> = arrayListOf()
    private var listOrder : ArrayList<Order> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerViewDelivery()

        setRecyclerViewOrder()

        // adding on click listener for our button.
        binding.filledTextShopLocation.setOnClickListener {

            val bottomSheetDialog = BottomSheetDialog(
                this@PaymentActivity, R.style.BottomSheetDialogTheme
            )

            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.btn_sheet_toko,
                findViewById<LinearLayout>(R.id.buttom_sheet)
            )

            bottomSheetView.findViewById<View>(R.id.btn_cabang_malang).setOnClickListener {
                Toast.makeText(this@PaymentActivity, "Cabang Malang", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.btnChoosePaymentMethod.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@PaymentActivity, R.style.BottomSheetDialogTheme
            )

            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.btn_sheet_method_payment,
                findViewById<LinearLayout>(R.id.buttom_sheet_method_payment)
            )

            bottomSheetView.findViewById<View>(R.id.btn_bank_btn).setOnClickListener {
                Toast.makeText(this@PaymentActivity, "Bank BTN", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.btnPay.setOnClickListener {
            val intent = Intent(this, ConfirmPaymentActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setRecyclerViewOrder(){
        listOrder.addAll(DataSource.listDataOrder)
        binding.rvOrderList.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = OrderAdapter(listOrder)
        }

    }

    private fun setRecyclerViewDelivery() {
        listDelivery.addAll(DataSource.listDataDelivery)
        binding.rvDelivery.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = PaymentAdapter(listDelivery)
        }
    }
}