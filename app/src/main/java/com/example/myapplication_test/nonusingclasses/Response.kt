package com.example.myapplication_test.nonusingclasses

import com.google.gson.annotations.SerializedName

data class Response(
    val statusCode: Long,
    val success: Boolean,
    val result: Result,
    val errors: List<Any?>,
)

data class Result(
    val asi: Asi,
    val config: Config20,
)

data class Asi(
    val orf5snmy: Orf5snmy,
)

data class Orf5snmy(
    val config: Config,
    val cmps: Cmps,
)

data class Config(
    val te: String,
    val ma: String,
    val at: String,
    val rwin: String,
    val adrt: String,
    val mdt: String,
    val plr: String,
    val nwhit: String,
    val pod: String,
    val podc: String,
)

data class Cmps(
    val dd: Dd,
)

data class Dd(
    @SerializedName("5394")
    val n5394: n5394,
)

data class n5394(
    val wt: String,
    val ads: Ads,
)

data class Ads(
    @SerializedName("ajio_462486395_burgundy")
    val ajio462486395Burgundy: Ajio462486395Burgundy,
    @SerializedName("ajio_460542734_red")
    val ajio460542734Red: Ajio460542734Red,
    @SerializedName("ajio_461197179_pink")
    val ajio461197179Pink: Ajio461197179Pink,
    @SerializedName("ajio_463715610_red")
    val ajio463715610Red: Ajio463715610Red,
    @SerializedName("ajio_460037419_red")
    val ajio460037419Red: Ajio460037419Red,
    @SerializedName("ajio_460764096_red")
    val ajio460764096Red: Ajio460764096Red,
    @SerializedName("ajio_440869374_dkbrown")
    val ajio440869374Dkbrown: Ajio440869374Dkbrown,
    @SerializedName("ajio_460326981_pink")
    val ajio460326981Pink: Ajio460326981Pink,
    @SerializedName("ajio_461946542_multi")
    val ajio461946542Multi: Ajio461946542Multi,
    @SerializedName("ajio_461197064_pink")
    val ajio461197064Pink: Ajio461197064Pink,
    @SerializedName("ajio_462020283_red")
    val ajio462020283Red: Ajio462020283Red,
    @SerializedName("ajio_460344571_maroon")
    val ajio460344571Maroon: Ajio460344571Maroon,
    @SerializedName("ajio_460344572_maroon")
    val ajio460344572Maroon: Ajio460344572Maroon,
    @SerializedName("ajio_460200985_wine")
    val ajio460200985Wine: Ajio460200985Wine,
    @SerializedName("ajio_461946851_multi")
    val ajio461946851Multi: Ajio461946851Multi,
    @SerializedName("ajio_460147750_wine")
    val ajio460147750Wine: Ajio460147750Wine,
    @SerializedName("ajio_460268954_blue")
    val ajio460268954Blue: Ajio460268954Blue,
    @SerializedName("ajio_460260636_wine")
    val ajio460260636Wine: Ajio460260636Wine,
)

data class Ajio462486395Burgundy(
    val ad: String,
    val config: Config2,
    val mod: Mod,
)

data class Config2(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod(
    val surl: List<String>,
)

data class Ajio460542734Red(
    val ad: String,
    val config: Config3,
    val mod: Mod2,
)

data class Config3(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod2(
    val surl: List<String>,
)

data class Ajio461197179Pink(
    val ad: String,
    val config: Config4,
    val mod: Mod3,
)

data class Config4(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod3(
    val surl: List<String>,
)

data class Ajio463715610Red(
    val ad: String,
    val config: Config5,
    val mod: Mod4,
)

data class Config5(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod4(
    val surl: List<String>,
)

data class Ajio460037419Red(
    val ad: String,
    val config: Config6,
    val mod: Mod5,
)

data class Config6(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod5(
    val surl: List<String>,
)

data class Ajio460764096Red(
    val ad: String,
    val config: Config7,
    val mod: Mod6,
)

data class Config7(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod6(
    val surl: List<String>,
)

data class Ajio440869374Dkbrown(
    val ad: String,
    val config: Config8,
    val mod: Mod7,
)

data class Config8(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod7(
    val surl: List<String>,
)

data class Ajio460326981Pink(
    val ad: String,
    val config: Config9,
    val mod: Mod8,
)

data class Config9(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod8(
    val surl: List<String>,
)

data class Ajio461946542Multi(
    val ad: String,
    val config: Config10,
    val mod: Mod9,
)

data class Config10(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod9(
    val surl: List<String>,
)

data class Ajio461197064Pink(
    val ad: String,
    val config: Config11,
    val mod: Mod10,
)

data class Config11(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod10(
    val surl: List<String>,
)

data class Ajio462020283Red(
    val ad: String,
    val config: Config12,
    val mod: Mod11,
)

data class Config12(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod11(
    val surl: List<String>,
)

data class Ajio460344571Maroon(
    val ad: String,
    val config: Config13,
    val mod: Mod12,
)

data class Config13(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod12(
    val surl: List<String>,
)

data class Ajio460344572Maroon(
    val ad: String,
    val config: Config14,
    val mod: Mod13,
)

data class Config14(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod13(
    val surl: List<String>,
)

data class Ajio460200985Wine(
    val ad: String,
    val config: Config15,
    val mod: Mod14,
)

data class Config15(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod14(
    val surl: List<String>,
)

data class Ajio461946851Multi(
    val ad: String,
    val config: Config16,
    val mod: Mod15,
)

data class Config16(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod15(
    val surl: List<String>,
)

data class Ajio460147750Wine(
    val ad: String,
    val config: Config17,
    val mod: Mod16,
)

data class Config17(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod16(
    val surl: List<String>,
)

data class Ajio460268954Blue(
    val ad: String,
    val config: Config18,
    val mod: Mod17,
)

data class Config18(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod17(
    val surl: List<String>,
)

data class Ajio460260636Wine(
    val ad: String,
    val config: Config19,
    val mod: Mod18,
)

data class Config19(
    val mdc: String,
    val fbk: String,
    val adr: String,
    val fmt: String,
    val cid: String,
)

data class Mod18(
    val surl: List<String>,
)

data class Config20(
    val csl: String,
    val ls: String,
    val ae: String,
    val te: String,
    val loc: String,
)