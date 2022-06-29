package com.ivanojok.interswitchapp.model

import com.google.gson.annotations.SerializedName


data class APIResponse (
    @SerializedName("responseCode")
    var responseCode: Long,
    @SerializedName("responseMessage")
    var responseMessage: String,
    @SerializedName("response")
    var response:Response?
)

data class Response (
    @SerializedName("name")
    var name: String,
    @SerializedName("payConfiguration")
    var payConfiguration: List<PayConfiguration>,
    @SerializedName("isInclusiveInAmount")
    var isInclusiveInAmount:Boolean,
    @SerializedName("hasProviderServiceCharge")
    var hasProviderServiceCharge:Boolean,
     @SerializedName("overrideBillerFee")
     var overrideBillerFee:Boolean,
     @SerializedName("vat")
     var vat:Float,
     @SerializedName("providerServiceCharge")
     var providerServiceCharge:Float,
     @SerializedName("taxAccount")
     var taxAccount:String,
     @SerializedName("withholdingTax")
     var withholdingTax:Float,
     @SerializedName("withholdingTaxAccount")
     var withholdingTaxAccount:String,
     @SerializedName("excise")
     var excise:Float,
     @SerializedName("exciseTaxAccount")
     var exciseTaxAccount:String,
     @SerializedName("providerServiceChargeAccount")
     var providerServiceChargeAccount:String,
    @SerializedName("feeGroups")
    var feeGroups:List<FeeGroups>?,
    @SerializedName("itemFeeMapSettings")
    var itemFeeMapSettings:List<ItemFeeMapSettings>?,
    @SerializedName("id")
    var id:Long,
    @SerializedName("isActive")
    var isActive: Boolean,
    @SerializedName("issueDate")
    var issueDate:String,
)


class PayConfiguration(
    @SerializedName("source")
    var source: String,
    @SerializedName("payType")
    var payType: String,
    @SerializedName("payValue")
    var payValue: Float,
    @SerializedName("maximumFeeBorn")
    var maximumFeeBorn: Float,
    @SerializedName("minimumFeeBorn")
    var minimumFeeBorn: Float,
    @SerializedName("itemFeeMapSettingId")
    var itemFeeMapSettingId: Int,
    @SerializedName("bandCode")
    var bandCode: String,
    @SerializedName("hasExcise")
    var hasExcise: Boolean,
    @SerializedName("isPayVAT")
    var isPayVAT: Boolean,
    @SerializedName("hasWithholdingTax")
    var hasWithholdingTax: Boolean,
    @SerializedName("hasServiceCharge")
    var hasServiceCharge: Boolean
)


class FeeGroups(
    @SerializedName("name")
    var name:String,
    @SerializedName("description")
    var description:String,
    @SerializedName("itemId")
    var itemId:Long,
    @SerializedName("itemFeeId")
    var itemFeeId:Long,
    @SerializedName("item")
    var item:String?,
    @SerializedName("clientFees")
    var clientFees:String?,
    @SerializedName("id")
    var id:Long,
    @SerializedName("isActive")
    var isActive:Boolean,
    @SerializedName("issueDate")
    var issueDate:String
)

class ItemFeeMapSettings(
    var unknown:String?
)