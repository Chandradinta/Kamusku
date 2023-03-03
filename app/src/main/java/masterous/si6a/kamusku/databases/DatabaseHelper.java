package masterous.si6a.kamusku.databases;

import static android.provider.BaseColumns._ID;
import static masterous.si6a.kamusku.databases.DatabaseContract.KamusColumns.KAMUS_DESCRIPTION;
import static masterous.si6a.kamusku.databases.DatabaseContract.KamusColumns.KAMUS_TITLE;
import static masterous.si6a.kamusku.databases.DatabaseContract.TABLE_KAMUS_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "dbkamus";
    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE_KAMUS = "CREATE TABLE " + TABLE_KAMUS_NAME +
            " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KAMUS_TITLE + " TEXT NOT NULL, " +
            KAMUS_DESCRIPTION + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KAMUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KAMUS_NAME);
        onCreate(db);
    }
}
