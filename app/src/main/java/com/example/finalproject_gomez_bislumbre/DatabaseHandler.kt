package com.example.finalproject_gomez_bislumbre

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "DisasterDatabase"
        private const val TABLE_DISASTERS = "DisasterTable"
        private const val KEY_ID = "id"
        private const val KEY_TYPE = "type"
        private const val KEY_DETAILS = "details"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_DISASTERS_TABLE = ("CREATE TABLE $TABLE_DISASTERS("
                + "$KEY_ID INTEGER PRIMARY KEY,"
                + "$KEY_TYPE TEXT,"
                + "$KEY_DETAILS TEXT)")

        db?.execSQL(CREATE_DISASTERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_DISASTERS")
        onCreate(db)
    }

    fun addDisaster(disaster: NaturalDisastersModelClass): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, disaster.disasterId)
        contentValues.put(KEY_TYPE, disaster.disasterType)
        contentValues.put(KEY_DETAILS, disaster.disasterDetails)

        val success = db.insert(TABLE_DISASTERS, null, contentValues)

        db.close()
        return success
    }

    @SuppressLint("Range")
    fun viewDisasters(): List<NaturalDisastersModelClass> {
        val disasterList: ArrayList<NaturalDisastersModelClass> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_DISASTERS"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var disasterId: Int
        var disasterType: String
        var disasterDetails: String

        if (cursor.moveToFirst()) {
            do {
                disasterId = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                disasterType = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
                disasterDetails = cursor.getString(cursor.getColumnIndex(KEY_DETAILS))
                val disaster = NaturalDisastersModelClass(disasterId, disasterType, disasterDetails)
                disasterList.add(disaster)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return disasterList
    }

    fun updateDisaster(disaster: NaturalDisastersModelClass): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, disaster.disasterId)
        contentValues.put(KEY_TYPE, disaster.disasterType)
        contentValues.put(KEY_DETAILS, disaster.disasterDetails)

        val success = db.update(TABLE_DISASTERS, contentValues, "$KEY_ID=" + disaster.disasterId, null)
        db.close()
        return success
    }

    //insert disasters for searching
    fun insertSampleDisasters() {
        val db = this.writableDatabase
        val contentValues = ContentValues()


        insertDisaster(db, contentValues, "Earthquake", "An earthquake is the result of the abrupt movement or breakage of a fault line, leading to the release of " +
                "stored elastic energy within strained rocks, causing the ground to shake.")
        insertDisaster(db, contentValues, "Flash floods", "Flash flooding is a swift-onset phenomenon, usually occurring within 3 to 6 hours of intense rainfall," +
                " commonly triggered by factors such as heavy rain from thunderstorms.")
        insertDisaster(db, contentValues, "Typhoon", "A tropical cyclone with strong winds and heavy rain.")
        insertDisaster(db, contentValues, "Drought", "Drought is an extended period of unusually low rainfall, causing water scarcity " +
                "and affecting agriculture, ecosystems, and human water sources.")
        insertDisaster(db, contentValues, "Heatwaves", "During a heatwave, humans face heightened health risks due to prolonged exposure to extreme temperatures, " +
                "leading to conditions such as heatstroke and dehydration.")
        insertDisaster(db, contentValues, "Smog", "Smog, a mix of pollutants, harms health by causing respiratory issues, aggravating conditions like asthma, and irritating eyes and throat. Prolonged exposure worsens respiratory and cardiovascular problems, " +
                "posing risks to well-being.")
        insertDisaster(db, contentValues, "Volcanic Eruption", "The phenomena when gas and/or lava are released from a volcano—sometimes explosively.")



        insertDisaster(db, contentValues, "Earthquake Preparedness and First Aid", "Learn more about Earthquake Preparedness and First Aid Information ")
        insertDisaster(db, contentValues, "Flash floods Preparedness Tips", "Learn more about Flash floods Preparedness Tips")
        insertDisaster(db, contentValues, "Typhoon Preparedness Tips and First Aid Information", "Learn more about Typhoon Preparedness tips and First Aid Information" )
        insertDisaster(db, contentValues, "Drought First Aid Information", "Learn more about Drought First Aid Information")
        insertDisaster(db, contentValues, "Heatwaves Preparedness Tips and First Aid Information", "Learn more about Heatwaves Preparedness Tips and First Aid Information")
        insertDisaster(db, contentValues, "Smog Inhalation Symptoms and First Aid Information", "Learn more about Smog Inhalation Symptoms and First Aid Information")
        insertDisaster(db, contentValues, "Volcanic Eruption Preparedness Tips", "Learn more about Volcanic Eruption Preparedness Tips")



        db.close()
    }

    private fun insertDisaster(db: SQLiteDatabase, contentValues: ContentValues, type: String, details: String) {
        contentValues.put(KEY_TYPE, type)
        contentValues.put(KEY_DETAILS, details)

        db.insert(TABLE_DISASTERS, null, contentValues)
    }

    fun deleteDisaster(disaster: NaturalDisastersModelClass): Int {
        val db = this.writableDatabase
        val success = db.delete(TABLE_DISASTERS, "$KEY_ID=" + disaster.disasterId, null)
        db.close()
        return success
    }


    @SuppressLint("Range")
    fun searchDisasters(query: String): List<NaturalDisastersModelClass> {
        val disasterList: ArrayList<NaturalDisastersModelClass> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_DISASTERS WHERE $KEY_TYPE LIKE ? OR $KEY_DETAILS LIKE ?"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, arrayOf("%$query%", "%$query%"))
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        if (cursor.moveToFirst()) {
            do {
                val disasterId = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val disasterType = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
                val disasterDetails = cursor.getString(cursor.getColumnIndex(KEY_DETAILS))
                val disaster = NaturalDisastersModelClass(disasterId, disasterType, disasterDetails)
                disasterList.add(disaster)

            } while (cursor.moveToNext())
        }
        cursor.close()
        return disasterList
    }

    fun clearDatabase() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_DISASTERS")
        db.close()
    }
}