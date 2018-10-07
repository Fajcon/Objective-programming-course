package macierze;

import javax.crypto.Mac;

public class Macierz {
    private int size_X;
    private int size_Y;
    public int[] table;
    public Macierz(int _size_X, int _size_Y, int[] _table){
        size_X = _size_X;
        size_Y = _size_Y;
        table = _table.clone();
    }

    public Macierz add(Macierz b){
        if (this.size_X == b.size_X && this.size_Y == b.size_Y) {
            Macierz result = new Macierz(size_X, size_Y, new int[size_X * size_Y]);
            for (int i = 0; i < size_Y * size_X; i++) {
                result.table[i] = this.table[i] + b.table[i];
            }
            return result;
        }
        return this;
    }

    public Macierz sub(Macierz b){
        if (this.size_X == b.size_X && this.size_Y == b.size_Y) {
            Macierz result = new Macierz(size_X, size_Y, new int[size_X * size_Y]);
            for (int i = 0; i < size_Y * size_X; i++) {
                result.table[i] = this.table[i] - b.table[i];
            }
            return result;
        }
        return this;
    }

    public Macierz mul(Macierz b){
        if (this.size_X == b.size_Y){
            int wiersz = 0;
            int kolumna = 0;
            Macierz result = new Macierz(b.size_X, this.size_Y, new int[b.size_X * this.size_Y]);
            int resultSize = b.size_X * this.size_Y;
            for (int k = 0; k < resultSize; k++) {
                if (k % result.size_X == 0 && k != 0) {
                    wiersz++;
                    kolumna = 0;
                }
                for (int i = 0; i < this.size_X; i++) {
                    result.table[k] += this.table[i + wiersz*this.size_X] * b.table[i*b.size_X+kolumna];
                }
                kolumna++;
            }
            return result;
        }
        return this;
    }
}
