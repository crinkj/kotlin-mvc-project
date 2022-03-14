package jpa.test.crm

import asia.marketit.influencercard.crm.Campaign
import asia.marketit.influencercard.crm.CampaignState
import asia.marketit.influencercard.crm.CampaignType
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Cycle(
        @Id @GeneratedValue
        val id: Long,

        @ManyToOne
        @JoinColumn(name="campaign_id")
        val campaign: Campaign,

        @ManyToOne
        @JoinColumn(name="organization_id")
        val organizationId:Organization,

        @ManyToOne
        @JoinColumn(name="brand_id")
        val brandId:Brand,

        @ManyToOne
        @JoinColumn(name="contract_id")
        var contractId: Contract,

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


        )

