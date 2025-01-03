package model;

import java.util.HashMap;
import java.util.List;


public class AddCheckoutModel {
    private String username;
    private String password;
    private List<String> items;
    private String key;

    public AddCheckoutModel(String username, String password, List<String> items, String key) {
        this.key = key;
        this.username = username;
        this.password = password;
        this.items = items;
    }

    public HashMap<String, AddCheckoutModel> setAddCheckoutModel(String key, AddCheckoutModel addCheckoutModel) {
        HashMap<String, AddCheckoutModel> data = new HashMap<String, AddCheckoutModel>();
        data.put(addCheckoutModel.key, addCheckoutModel);
        return data;
    }

    public HashMap<String, AddCheckoutModel> getAddCheckoutModel(String keys) {
        HashMap<String, AddCheckoutModel> data = new HashMap<String, AddCheckoutModel>();
        data.put(keys, new AddCheckoutModel(username, password, items, key));
        return data;
    }

    public String getUsernameByKeys(String keys) {
        return getAddCheckoutModel(keys).get(keys).username;
    }

    public String getPasswordByKeys(String keys) {
        return getAddCheckoutModel(keys).get(keys).password;
    }

    public List<String> getItemsByKeys(String keys) {
        return getAddCheckoutModel(keys).get(keys).items;
    }

    public String getKey() {
        return key;
    }

}
