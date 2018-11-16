package appl;

import excp.BadInputException;
import excp.NothingToSubstractFromException;
import excp.TooBigNumberException;

public abstract class Calculator {
    public void SaveToFile(String x, String filename){

    }
    public abstract void Add(String x);
    public abstract void Substract(String x) throws NothingToSubstractFromException, BadInputException;
    public abstract void Multiply(int x) throws TooBigNumberException;
}
