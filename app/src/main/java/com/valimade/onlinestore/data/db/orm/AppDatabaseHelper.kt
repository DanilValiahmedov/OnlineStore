package com.valimade.onlinestore.data.db.orm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class AppDatabaseHelper(context: Context) : OrmLiteSqliteOpenHelper(
    context,
    "app.db",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?, cs: ConnectionSource?) {
        TableUtils.createTableIfNotExists(cs, ProductEntity::class.java)
    }

    fun productDao(): Dao<ProductEntity, Int> = getDao(ProductEntity::class.java)


    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {}
}