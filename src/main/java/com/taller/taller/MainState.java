package com.taller.taller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainState {

    private static volatile MainState _instance = null;
    private List<Map<String,Object>> state = new ArrayList<>();

    public static MainState getInstance() {
        if (_instance == null) {
                if (_instance == null) {
                    _instance = new MainState();
                }
            }
        return _instance;
    }

   public Map<String, Object> getCurrentState(){
        return state.size() > 0 ? state.get(state.size()) : null;
   }

   public Map<String, Object> getPreviousState(){
        return state.size() - 1 > 0 ? state.get(state.size() - 1) : null;
   }

   public void addNewState(Map<String,Object> newState){
        state.add(newState);
        if(state.size() >= 4) state.remove(0);
   }

   public void setCurrentState(Map<String,Object> currentState){
        if(state.size() > 0) {
            state.set(state.size(), currentState);
        }else{
            state.add(currentState);
        }
   }

   public void clearState(){
        state.clear();
   }
}
