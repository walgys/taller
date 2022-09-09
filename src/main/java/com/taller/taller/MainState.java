package com.taller.taller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainState {

    private static volatile MainState _instance = null;
    private Map<String,Object> state = new HashMap<>();

    public static MainState getInstance() {
        if (_instance == null) {
                if (_instance == null) {
                    _instance = new MainState();
                }
            }
        return _instance;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setStateProperty(Map<String,Object> data, String key) {
        state.put(key,data);
    }
}
