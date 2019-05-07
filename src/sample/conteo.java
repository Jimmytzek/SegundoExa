package sample;

import javafx.application.Platform;
import javafx.scene.control.*;

public class conteo extends Thread {

    Thread hilo = new Thread();

    private Button tirar;
    private ProgressBar barraprogreso;
    private ProgressIndicator indicadorprogreso;
    private  Label imprimir;
    private int co=0;



    public conteo(Button tirar, ProgressBar barraprogreso, ProgressIndicator indicadorprogreso, Label imprimir) {

        super();
        this.imprimir=imprimir;
        this.tirar = tirar;
        this.barraprogreso = barraprogreso;
        this.indicadorprogreso = indicadorprogreso;
    }

    @Override
    public void run() {
        for (int co=1;co<=60000;co++){
            imprimir.setText(String.valueOf(co));
        }
    }


    }

