package com.ivanojok.interswitchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ivanojok.interswitchapp.model.APIResponse
import com.ivanojok.interswitchapp.model.ItemDataEntity
import com.ivanojok.interswitchapp.repository.GetItemDataDao
import com.ivanojok.interswitchapp.repository.ItemDataRepository
import com.ivanojok.interswitchapp.viewmodel.ItemViewModel
import com.ivanojok.interswitchapp.viewmodel.ItemViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:ItemViewModel
    class itemDao: GetItemDataDao{}
    lateinit var itemRepository:ItemDataRepository
    lateinit var factory: ItemViewModelFactory
    lateinit var des:TextView
    lateinit var input:EditText
    lateinit var search:ImageView
    lateinit var data: APIResponse
    lateinit var offlineData: ItemDataEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemRepository = ItemDataRepository(itemDao())
        factory = ItemViewModelFactory(itemRepository)

       viewModel = ViewModelProvider(this, factory).get(ItemViewModel::class.java)

        des = findViewById<TextView>(R.id.des)
        input = findViewById(R.id.id)
        search = findViewById(R.id.search)

        search.setOnClickListener {
            val id = input.text.toString()
            if (id.isNotEmpty() && id.isDigitsOnly()){
                val itemId = id.toLong()


                viewModel.viewModelScope.launch {
//                   offlineData = viewModel.getItemDetails(itemId)
                   if (viewModel.getItemDetails(itemId) != null){
                       des.setText(data.toString())
                   }
                   else{
                    data = viewModel.getAPIData(itemId)
                    if(data != null){
                        des.setText(data.toString())
                        val value = data
                        val resp = value.response!!

                        val itemEntity = ItemDataEntity(value.responseCode, value.responseMessage,
                            resp.name, resp.payConfiguration, resp.isInclusiveInAmount, resp.hasProviderServiceCharge,
                        resp.overrideBillerFee, resp.vat, resp.providerServiceCharge, resp.taxAccount, resp.withholdingTax,
                        resp.withholdingTaxAccount, resp.excise, resp.exciseTaxAccount, resp.providerServiceChargeAccount,
                        resp.feeGroups, resp.itemFeeMapSettings, resp.id, resp.isActive, resp.issueDate)
                        viewModel.insert(itemEntity)
                          }
                    }
                }
            }
            else{
                Toast.makeText(this, "Fill in an id", Toast.LENGTH_SHORT).show()
            }
        }

//        viewModel.viewModelScope.launch {
//            val data = viewModel.getAPIData(31196)
//            des.setText(data.toString())
//
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = MenuInflater(this).inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.search -> {
                return true
            }
            R.id.delete -> {
                viewModel.viewModelScope.launch {
                    viewModel.delete()
                }
            }
            else -> return true
        }
        return super.onOptionsItemSelected(item)
    }
}