package com.ivanojok.interswitchapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ItemDataEntity(
    @ColumnInfo(name = "responseCode")
    var responseCode:Long,
    @ColumnInfo(name = "responseMessage")
    var responseMessage: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "payConfiguration")
    var payConfiguration: List<PayConfiguration>,
    @ColumnInfo(name = "isInclusiveInAmount")
    var isInclusiveInAmount: Boolean,
    @ColumnInfo(name = "hasProviderServiceCharge")
    var hasProviderServiceCharge: Boolean,
    @ColumnInfo(name = "overrideBillerFee")
    var overrideBillerFee: Boolean,
    @ColumnInfo(name = "vat")
    var vat: Float,
    @ColumnInfo(name = "providerServiceCharge")
    var providerServiceCharge: Float,
    @ColumnInfo(name = "taxAccount")
    var taxAccount: String,
    @ColumnInfo(name = "withholdingTax")
    var withholdingTax: Float,
    @ColumnInfo(name = "withholdingTaxAccount")
    var withholdingTaxAccount: String,
    @ColumnInfo(name = "excise")
    var excise: Float,
    @ColumnInfo(name = "exciseTaxAccount")
    var exciseTaxAccount: String,
    @ColumnInfo(name = "providerServiceChargeAccount")
    var providerServiceChargeAccount: String,
    @ColumnInfo(name = "feeGroups")
    var feeGroups: List<FeeGroups>?,
    @ColumnInfo(name = "itemFeeMapSettings")
    var itemFeeMapSettings: List<ItemFeeMapSettings>?,
    @PrimaryKey(autoGenerate = false)
    var id: Long,
    @ColumnInfo(name = "isActive")
    var isActive: Boolean,
    @ColumnInfo(name = "issueDate")
    var issueDate: String,


)