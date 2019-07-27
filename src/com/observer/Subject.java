package com.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

  protected List<Observator> observersList;

  public Subject() {
    this.observersList = new ArrayList<>();
  }


  public void registerObserver(Observator observator) {
    observersList.add(observator);
  }


  public void unregisterObserver(Observator observator) {
    observersList.remove(observator);
  }

  public List<Observator> getObserversList() {
    return observersList;
  }

}
