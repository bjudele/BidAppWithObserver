package com.observer;

import com.bid.Bid;
import java.util.ArrayList;
import java.util.List;

public abstract class Observator {

  protected List<Subject> observedSubjects;

  public Observator() {
    observedSubjects = new ArrayList<>();
  }

  public void observe(Subject... subjectArray) {
    for (int index = 0; index < subjectArray.length; index++) {
      Subject subject = subjectArray[index];
      observedSubjects.add(subject);
      subject.registerObserver(this);
    }
  }
  public void detach(Subject subject) {
      observedSubjects.remove(subject);
      subject.unregisterObserver(this);

  }
  public abstract void update(Bid bid);
}
