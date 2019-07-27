package com.bid;

import com.observer.Observator;
import java.util.ArrayList;
import java.util.List;

public class Auction {

  private List<Item> itemList;
  private List<Participant> participantList;

  public Auction() {
    this.itemList = new ArrayList<>();
    this.participantList = new ArrayList<>();
  }

  public void registerItemsForSelling(Item... itemArray) {
    for (int index = 0; index < itemArray.length; index++) {
      itemList.add(itemArray[index]);
    }
  }

  public void startAuction() {
    for (Item each : itemList) {
      startBiddingFor(each);
    }
  }

  private void startBiddingFor(Item item) {
    System.out.println("\n\n Bid for " + item.getName() + " started!");
    Bid initialBid = createInitialBid(item);
    registerBid(initialBid);
    askBiddersToBidFor(item);
  }

  private void askBiddersToBidFor(Item item) {
    boolean bidWasPlaced;
    do {
      bidWasPlaced = false;
      for (Participant each : participantList) {
        if (each.isInterestedIn(item)) {
          bidWasPlaced = bidWasPlaced | each.placeBid();
        }
      }
    } while (bidWasPlaced);
  }

  private Bid createInitialBid(Item item) {
    return new Bid(item.getStartingPrice() - 1, item, null);
  }

  public void registerParticipants(Participant... participants) {
    for (int index = 0; index < participants.length; index++) {
      participantList.add(participants[index]);
      participants[index].setAuction(this);
    }
  }

  public void registerBid(Bid bid) {
    List<Observator> itemObservers = bid.getObservers();
    for (Observator each : itemObservers) {
      each.update(bid);
    }

  }
}
