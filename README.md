## Context
Bidding App is an application that allows its customers to take part of an auction and anonymously bid for different items registered by the admins of the application. As in any auction, whoever bids with the highest number for an item wins the right to purchase it. Of course, once a participant places a bid, any other participant can outbid them by placing a higher number (amount of money) for the same item.

## Your tasks

- Create the classes required to represent all the entities mentioned above. You should have **at least** the following classes: Auction, AuctionParticipant, Item.
- Create the &quot;bid&quot; functionality that should allow an auction participant to place a bid for an item.

What data structures do you need to use for implementing this? There is no single way of doing this right, sky&#39;s the limit here, so go wild! 😊

- Create a mechanism that would automatically notify all the auction participants who bid for a specific item if a higher bid was placed for the same item.

  Ex: Jon bids 6 USD for a keyboard;
  
  Jack bids 7USD for the same keyboard – the app would notify Jon that he was outbid;
  
  Jill bids 8USD for the same keyboard – the app would notify both Jon and Jack that they were outbid.

## Bonus

- Every auction participant should have a maximum budged that they can use for placing bids. If a user places a bid for an item and they receive a notification saying that they were outbid, they should automatically place a higher bid, as long as the amount is within their budget.
