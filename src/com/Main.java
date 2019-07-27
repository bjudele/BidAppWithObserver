package com;

import com.bid.Auction;
import com.bid.Item;
import com.bid.Participant;

public class Main {

  public static void main(String[] args) {

    Item bike = new Item("bike", 23);
    Item keyboard = new Item("keyboard", 12);
    Item sunglasses = new Item("sunglasses", 6);

    Participant jack = new Participant("jack", 100);
    Participant john = new Participant("john", 130);
    Participant jill = new Participant("jill", 40);

    jack.observe(bike, keyboard);
    john.observe(keyboard, sunglasses);
    jill.observe(sunglasses, bike);

    Auction auction = new Auction();
    auction.registerItemsForSelling(bike, keyboard, sunglasses);
    auction.registerParticipants(jack, john, jill);

    auction.startAuction();


  }
}
