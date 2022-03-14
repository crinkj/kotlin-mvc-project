package jpa.test.crm

import asia.marketit.influencercard.crm.Campaign
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class CampaginCategory (
    @Id @GeneratedValue
    val id:Long,

    @ManyToOne
    @JoinColumn(name="campaign_id")
    var campaignId:Campaign,

    @OneToMany(mappedBy = "category")
    var categoryId:Category,

    val createdDate:Instant,

    val updatedDate:Instant

    )