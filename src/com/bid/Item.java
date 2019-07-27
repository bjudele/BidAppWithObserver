package com.bid;


import com.observer.Subject;

public class Item extends Subject {

  private String name;
  private int startingPrice;
  private Participant winner;

  public Item(String name, int startingPrice) {
    this.name = name;
    this.startingPrice = startingPrice;
  }

  public String getName() {
    return name;
  }

  public int getStartingPrice() {
    return startingPrice;
  }

  public void setWinner(Participant winner) {
    this.winner = winner;
  }

  public Participant getWinner() {
    return winner;
  }
}
