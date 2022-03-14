package asia.marketit.influencercard.crm

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Campaign(
    @Id @GeneratedValue
    val id: Long,
    val brandId: Long,
    val contractId: Long,
    var beginAt: LocalDateTime,
    var terminateAt: LocalDateTime,
    var title: String,
    var content: String,
    @Enumerated(EnumType.STRING)
    val status:CampaignStatus,
    @Enumerated(EnumType.STRING)
    val type:CampaignType,
    var address:String,
    var detailAddress:String,
    var note:String,
    val createdAt:LocalDateTime

)

// 캠페인  상태: Approved(승인) rejected(거절)
enum class CampaignStatus{
    APPROVED, REJECTED
}

enum class CampaignType{
    ONLINE,OFFLINE
}