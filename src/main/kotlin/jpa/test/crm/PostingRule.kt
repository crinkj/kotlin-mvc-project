package jpa.test.crm

import java.time.Instant
import javax.annotation.processing.Generated
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class PostingRule (

    @Id @Generated
    val id:Long,
    var postingConnected:Int,
    var postingMaintained:Int,
    var adTop:String,
    var adBottom:String,
    var officialTag:String,
    var hashTag:String,
    var firstContent:String,
    var uploadVideo:Int,
    var uploadImage:Int,
    var caution:String,
    var createdAt:Instant,
    var updatedAt:Instant
)