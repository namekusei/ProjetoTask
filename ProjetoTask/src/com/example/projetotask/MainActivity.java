package com.example.projetotask;




import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.database.Cursor;



public class MainActivity extends Activity {
	
		Button btnDatainicio, btnDataFim, btnHoraInicio, btnHoraFim;
		
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	    //}
	
	    DBAdapter db = new DBAdapter(this);
	    
	    // add Tarefa
	    db.open();        
	    long id = db.insertTarefa("Jogar video game", "12/12/2016", "25/12/2016", "10:45:00", "10:45:00");        
	    id = db.insertTarefa("Viajar a passeio", "02/01/2017", "15/01/2017", "10:45:00", "10:45:00");
	    db.close();

	    //---pegar todas as tarefas---
	    db.open();
	    Cursor c = db.getAllTarefa();
	    if (c.moveToFirst())
	    {
	        do {          
	            DisplayTarefa(c);
	        } while (c.moveToNext());
	    }
	    db.close();
	    
	  //---update tarefa---
	    db.open();
	    if (db.updateTarefa(1, "Jogar video game", "12/12/2016", "25/12/2016", "10:45:00", "10:45:00"))
	        Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
	    else
	        Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();        
	    db.close();
	    
	  //----deleta tarefa---
	    db.open();
	    if (db.deleteTarefa(1))
	        Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
	    else
	        Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();            
	    db.close();
	    }
	    
	    public void DisplayTarefa(Cursor c)
	    {
	        Toast.makeText(this, 
	                "id: " + c.getString(0) + "\n" +
	                "Nome da Tarefa: " + c.getString(1) + "\n" +
	                "Data Inicio:  " + c.getString(2) + "\n" + 
	                "Data Final:  " + c.getString(3) + "\n"+
	                "Horario Inicio:  " + c.getString(4) + "\n"+ 
	    	        "Horario Final:  " + c.getString(5),
	                Toast.LENGTH_LONG).show();    
	    } 
    
	}


    
    
    


