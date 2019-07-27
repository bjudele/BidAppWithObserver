package com.bid;

import com.observer.Observator;

public class Participant extends Observator {

  private Auction auction;
  private String name;
  private int budget;
  private Bid latestBidInAuction;

  public Participant(String name, int budget) {
    this.name = name;
    this.budget = budget;
  }

  @Override
  public void update(Bid bid) {
    if (isOwnBid(bid) == false) {
      System.out.println(
          name + " received an update that the current price for " + bid.getItemName() + " is "
              + bid.getValue());
    }
    latestBidInAuction = bid;
  }


  private void outbid(Bid bid) {
    Bid higherBid = createBidHigherThan(bid);
    System.out.println(
        name + " places new bid for " + higherBid.getItemName() + ": " + higherBid.getValue());
    auction.registerBid(higherBid);
  }

  public boolean placeBid() {
    if (hasBudgetToOutbid() && participantWon() == false) {
      outbid(latestBidInAuction);
      return true;
    }
    if (participantWon()) {
      declareWinner();
    } else {
      System.out.println(
          name + " has no budget available to bid for " + latestBidInAuction.getItemName());
      detach(latestBidInAuction.getItem());
    }
    return false;
  }

  private boolean participantWon() {
    return isOwnBid(latestBidInAuction);
  }

  private boolean hasBudgetToOutbid() {
    int bidValue = latestBidInAuction.getValue();
    return budget > bidValue;
  }

  private void declareWinner() {
    latestBidInAuction.setWinner(this);
    System.out.println(
        name + " won the auction for " + latestBidInAuction.getItemName() + " with a price of "
            + latestBidInAuction.getValue());

  }

  private Bid createBidHigherThan(Bid bid) {
    return new Bid(bid.getValue() + 1, bid.getItem(), this);
  }

  private boolean isOwnBid(Bid bid) {
    return bid.getOwner() != null && bid.getOwner().equals(this);
  }


  public boolean isInterestedIn(Item item) {
    return this.observedSubjects.contains(item);
  }

  public void setAuction(Auction auction) {
    this.auction = auction;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Participant that = (Participant) o;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

}
