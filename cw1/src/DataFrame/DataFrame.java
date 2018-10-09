package DataFrame;

import java.util.ArrayList;

public class DataFrame {
    private  String [] names;
    private  String [] types;
    ArrayList<ArrayList> data = new ArrayList<ArrayList>();

    public DataFrame(String[] _names, String[] _types){
        names = _names.clone();
        types = _types.clone();
        for (int i = 0; i < _names.length; i++) {
            data.add(new ArrayList());
        }

    }

    public int size(){
        return data.get(0).size();
    }

    public ArrayList get(String colname){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == colname){
                return data.get(i);
            }
        }
        return new ArrayList();
    }

    public DataFrame get(String[] cols, boolean copy){
        String[] newTypes = new String[cols.length];
        for (int i = 0; i <cols.length ; i++) {
            for (int j = 0; j <names.length ; j++) {
                if (cols[i].equals(names[j])){
                    newTypes[i] = types[j];
                }
            }
        }
        DataFrame results = new DataFrame(cols, newTypes);

        for (int i = 0; i <cols.length ; i++) {
            for (int j = 0; j <names.length ; j++) {
                if (cols[i].equals(names[j])){
                    if (copy) System.arraycopy(data.get(i), 0, results.data.get(j), 0, size());
                    else results.data.set(j, data.get(i));
                }
            }
        }
        return results;
    }

    public DataFrame iloc(int i){
        DataFrame result = new DataFrame(names, types);
        for (int j = 0; j < names.length; j++) {
            result.data.get(j).add(data.get(j).get(i));
        }
        return result;
    }

    public DataFrame iloc(int from, int to){
        DataFrame result = new DataFrame(names, types);
        for (int j = 0; j < names.length; j++) {
            System.arraycopy(data.get(j), from, result.data.get(j), from, to-from);
        }
        return result;
    }
}
