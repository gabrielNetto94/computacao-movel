package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.widget.Toast;

public class ModelCar {

    SQLiteDatabase db;
    private String BANCO = "cars.db";
    private Context ctx;

    public void createDataBase(){
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS carro (" +
                "ID INTEGER PRIMARY KEY, " +
                "NOME TEXT, " +
                "PLACA TEXT, " +
                "ANO TEXT);");
        db.close();
    }

    public ModelCar(Context ctx){
        this.ctx = ctx;
    }

    public void insertCar(Editable nome, Editable placa, Editable ano){
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("INSERT INTO carro (NOME, PLACA, ANO) VALUES (" +
                "'"+nome+"','"+placa+"','"+ano+"')");
        db.close();
        Toast.makeText(ctx, "Dados inseridos", Toast.LENGTH_SHORT).show();
    }

    public void updateCar(int id, String nome, String placa, String ano){
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("UPDATE carro SET NOME = '"+nome+"'," +
                "PLACA = '"+placa+"'," +
                "ANO = '"+ano+"' WHERE ID = "+id);
        db.close();
        Toast.makeText(ctx, "Dados alterados", Toast.LENGTH_SHORT).show();

    }

    public void deleteCar(int id){
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("DELETE FROM carro WHERE ID = "+id);
        db.close();
        Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show();
    }

    public String selectCar(String nome){
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        //Cursor linhas = db.rawQuery("SELECT * FROM carro WHERE nome = '"+nome+"'", null);
        Cursor linhas = db.rawQuery("SELECT * FROM carro", null);
        //poderia ser feito assim também:
        //Cursor linhas = db.rawQuery("SELECT * FROM carro WHERE nome = ?", new String[] { nome });

        String retorno = "";
        if(linhas.moveToFirst()){ //retorna false se não há linhas na tabela
            do{
                String ID = linhas.getString(0);
                String NOME = linhas.getString(1);
                String PLACA = linhas.getString(2);
                String ANO = linhas.getString(3);
                retorno+=ID+","+ NOME+","+PLACA+","+ANO+"\n";
            }
            while(linhas.moveToNext()); //laço até a última linha da tabela
        }
        db.close();
        return retorno;
    }


}
