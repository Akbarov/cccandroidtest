package uz.soliq.cccandroidtest.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
class Estimate(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "company") var company: String? = null,
    @ColumnInfo(name = "address") var address: String? = null,
    @ColumnInfo(name = "number") var number: Int? = null,
    @ColumnInfo(name = "revision_number") var revision_number: Int? = null,
    @ColumnInfo(name = "created_date") var created_date: String? = null,
    @ColumnInfo(name = "created_by") var created_by: String,
    @ColumnInfo(name = "requested_by") var requested_by: String,
    @ColumnInfo(name = "contact") var contact: String
) {
    override fun toString(): String {
        return "id = $id" +
                " company = $company" +
                " address = $address" +
                " number = $number" +
                " revision = $revision_number" +
                " created By = $created_by" +
                " created Date = $created_date" +
                " requested By  = $requested_by" +
                " contact  = $contact"
    }
}

class EstimateWithLink(
    val id: String,
    var company: String?,
    var address: String?,
    var number: Int?,
    var created_date: String?,
    var created_by: Person?,
    var requested_by: Person?,
    var contact: Person?
) {
    override fun toString(): String {
        return "id = $id" +
                " company = $company" +
                " address = $address" +
                " number = $number" +
                " created By = ${created_by.toString()}" +
                " created Date = $created_date" +
                " requested By  = ${requested_by.toString()}" +
                " contact  = ${contact.toString()}"
    }
}

@Entity
class Person(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "first_name") var first_name: String? = null,
    @ColumnInfo(name = "last_name") var last_name: String? = null,
    @ColumnInfo(name = "email") var email: String? = null,
    @ColumnInfo(name = "phone_number") var phone_number: String? = null,

    ) {
    override fun toString(): String {
        return "id = $id " +
                " first_name = $first_name" +
                " last_name = $last_name" +
                " email = $email" +
                " phone = $phone_number"
    }
}

