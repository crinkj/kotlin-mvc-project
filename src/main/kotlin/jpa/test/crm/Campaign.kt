package asia.marketit.influencercard.crm

import jpa.test.crm.Brand
import jpa.test.crm.Contract
import jpa.test.crm.Cycle
import jpa.test.crm.Organization
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Campaign(
        @Id @GeneratedValue
        val id: Long,

        @ManyToOne
        @JoinColumn(name="organization_id")
        val organizationId:Organization,

        @ManyToOne
        @JoinColumn(name="brand_id")
        val brandId:Brand,

        @ManyToOne
        @JoinColumn(name="contract_id")
        val contractId: Contract,

        var adminId: Long,

        var operationManager: Long,

        var salesManager: Long,

        var startedAt: LocalDateTime,

        var endedAt: LocalDateTime,

        var recruitedAt: LocalDate,

        var title:String,

        var content:String,

        var state: CampaignState,

        var type: CampaignType,

        var note: String,

        val createdAt: Instant,

        val updatedAt: Instant,

        @OneToMany(mappedBy = "cycle_id")
        val cycleList: ArrayList<Cycle>

)

// 캠페인  상태: Approved(승인) rejected(거절)
enum class CampaignState {
    APPROVED, REJECTED
}

enum class CampaignType {
    ONLINE, OFFLINE
}

// 캠페인 추가시 회차 추가(
/*fun addCycle(cycle: Cycle, camp: Campaign) {
    cycle.apply {
        this.campaignId = camp.id
        this = cycleCount(camp.id)
        this.startAt = camp.startAt
        this.endAt = camp.endAt
        this.title = camp.title
        this.content = camp.content
        this.cycleStatus = camp.campStatus
        this.address = camp.campAddress
        this.detailAddress = camp.campDetailAddress
        this.phone = camp.phone
    }
}*/

// cycle Count 가져오는 함수
fun cycleCount(campId: Long): Int {
    // 조회후 있을시 count +1로직
    return 1
}