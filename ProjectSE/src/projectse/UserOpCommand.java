/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UserOpNotFoundException;
import com.vm.jcomplex.Complex;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Group3
 */
/*
La classe UserOpCommand contiene il nome, gli operatori e la calcolatrice associati ad un'operazione-utente.
In essa sono presenti, inoltre, uno Stack ed una VarCollection di appoggio, utili per salvare i valori 
dello Stack e delle variabili presenti nella calcolatrice nel corso dell'esecuzione di un'operazione-utente.
Infine, sono presenti i metodi necessari al funzionamento delle operazioni-utente.
 */
public class UserOpCommand implements Command, Serializable {

    private String name;
    private String operation;
    private Calculator calc;
    private Deque<Complex> stackApp;
    private VarCollection<Complex> varsApp;

    public UserOpCommand(String name, String operation, Calculator calc) {
        name = name.trim();
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
        operation = operation.trim();
        if (calc.recUserOp(name + " " + operation) == -1) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.operation = operation;
        this.calc = calc;
    }

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public void setCalc(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public String toString() {
        return name + " " + operation;
    }

    /*
    Il metodo execute() esegue un'operazione-utente eseguendo ogni operatore/operazione-utente
    contenuto in essa. Lancia l'eccezione UserOpNotFoundException in caso di operazione non trovata
     */
    @Override
    public void execute() {

        //vengono conservati lo stack e le variabili presenti nella calcolatrice prima di iniziare l'esecuzione
        //dell'operazione utente
        stackApp = new ArrayDeque<>(calc.getStack());
        varsApp = new VarCollection(calc.getVars());
        String operator[] = operation.split(" ");
        for (String op : operator) {
            int id = calc.recognizer(op);
            if (id == 0) {
                calc.pushComplex(op);
            } else if (id > 0 && id <= 11) {
                calc.makeOperation(id);
            } else if (id >= 13 && id <= 16) {
                calc.makeVarOperation(id, op.charAt(1));
            } else if (id == 18) {
                calc.getUserOpMap().get(op).execute();
            } else {
                throw new UserOpNotFoundException();
            }
        }
    }

    /*
    Il metodo rollback() ripristina lo stato dello stack e delle variabili della calcolatrice
     */
    @Override
    public void rollback() {
        calc.setStack(stackApp);
        calc.setVars(varsApp);
    }

    /*
    Il metodo delete() elimina un'operazione-utente adottando una politica CASCADE:
    vengono ricercate ed eliminate tutte le operazioni-utente che contengono quella eliminata, viene
    ripetuto il procedimento anche su queste ultime e così via
     */
    @Override
    public void delete() {
        ConcurrentMap<String, UserOpCommand> map = calc.getUserOpMap();
        map.remove(name);
        for (Map.Entry<String, UserOpCommand> entry : map.entrySet()) {
            if (entry.getValue().operation.contains(name)) {
                entry.getValue().delete();
                map.remove(entry.getKey());
            }
        }
    }

}
