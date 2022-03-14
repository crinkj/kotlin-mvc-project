package jpa.test.crm

import asia.marketit.influencercard.crm.Campaign
import java.time.Instant
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class CampaignAttachment(
        @Id @GeneratedValue
        val id:Long,

        @ManyToOne
        @JoinColumn(name="campaign_id")
        val campaignId:Campaign,

        var organizationId:Long,

        @Enumerated(EnumType.STRING)
        var type:AttachmentType,

        val createdAt:Instant,

        val updatedAt:Instant
)

enum class AttachmentType{
        VIDEO,IMAGE
}