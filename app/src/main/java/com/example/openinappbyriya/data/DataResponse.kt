package com.example.demoretrofit.data

data class DataResponse(

    val status: Boolean,
    val statusCode: Int,
    val message: String,
    val support_whatsapp_number: String,
    val extra_income: Double,
    val total_links: Int,
    val total_clicks: Int,
    val today_clicks: Int,
    val top_source: String,
    val top_location: String,
    val startTime: String,
    val links_created_today: Int,
    val applied_campaign: Int,
    val data: Datas

)
data class Datas(
    val recent_links: List<Links>,
    val top_links: List<Links>,
    val overall_url_chart: Map<String, Int>
)

data class Links(
    val url_id: Int,
    val web_link: String,
    val smart_link: String,
    val title: String,
    val total_clicks: Int,
    val original_image: String?,
    val thumbnail: String?,
    val times_ago: String,
    val created_at: String,
    val domain_id: String,
    val url_prefix: String?,
    val url_suffix: String,
    val app: String
)
