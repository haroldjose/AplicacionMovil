package tiroconarco.harold.tesisporyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //creacion de las tablas bd

    @Override
    public void onCreate(SQLiteDatabase db) {
        // se crea los script
        db.execSQL(Utilidades.CREATE_TABLE_DATOSRONDA);
        db.execSQL(Utilidades.CREATE_TABLE_PUNTAJE);
        db.execSQL(Utilidades.CREATE_TABLE_CHECK_EJERCICIO);
        db.execSQL(Utilidades.CREATE_TABLE_CHECK_PRACTICA);
        db.execSQL(Utilidades.INSERT_DATA_EJERCICIO);
        db.execSQL(Utilidades.INSERT_DATA_PRACTICA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        // refrescamos volviendo a generar script
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_RONDA);
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_PUNTAJE);
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_EJERCICIO);
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_PRACTICA);
        onCreate(db);

    }

}
