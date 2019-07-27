package com.bid;


import com.observer.Observator;
import java.util.List;

public class Bid {

  private int value;
  private Item item;
  private Participant owner;

  public Bid(int value, Item item, Participant owner) {
    this.value = value;
    this.item = item;
    this.owner = owner;
  }

  public int getValue() {
    return value;
  }

  public Item getItem() {
    return item;
  }

  public String getItemName() {
    return item.getName();
  }

  public List<Observator> getObservers() {
    return item.getObserversList();
  }

  public Participant getOwner() {
    return owner;
  }

  public void setWinner(Participant winner) {
    item.setWinner(winner);
  }

  public boolean isWinner() {
    return item.getWinner() != null;
  }
}
