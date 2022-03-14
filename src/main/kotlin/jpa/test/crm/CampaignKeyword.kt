package jpa.test.crm

import asia.marketit.influencercard.crm.Campaign
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class CampaignKeyword (
        @Id @GeneratedValue
        val id:Long,

        @ManyToOne
        @JoinColumn(name="campaign_id")
        var campaignId:Campaign,

        var keyword:String,

        val createdAt:Instant,

        val updatedAt:Instant

        )