# Online video games store (Semester Project)
The system that lets users buy games online

## Abstract
The aim of this project is to create an online game shop. The idea came due to the dangers for today’s society to shop in physical stores and physical limitations.
Technical details include developing a 3-tier architecture system. Also, includes the RESTful and sockets communication between tiers.
The project features full Blazor architecture, C#, and Java.
The results are that the system is complete with all requirements
implemented. However, there are some bugs, but the main system is working as intended. 

## Methodology
* Scrum
* Unified Software Development process

## Analysis
The main problem consists of the current danger of shopping in a physical game store
because of the pandemic, struggle to find the selected title and limited stock along with
waiting queues for purchasing a new game. The customer wants an online access
service with a wide variety of titles to choose from with no concern of not being able to
purchase a wanted new release. These main objects could be fulfilled by making an
online video game store. The decision was made to develop it, by having a 3-tier
distributed system that would have a broad assortment of video games to choose from
with the capability to purchase a game with minimal effort and receive it instantly after a
purchase has been made. 

## Functional Requirements
**Critical Priority**
1. As a customer, I want to be able to purchase a game such that I would receive
the game key
2. As a customer, I want to get a receipt after purchasing, such that in case of
error I would have proof of purchase. 
3. As a customer, I want to be able to register as a user, such that I would be able
to log in.
4. As a customer, I want to be able to log in as a user, such that I would be able to
purchase a game. 

**High Priority**

5. As a customer, I want to be able to browse game, such that I could choose
which ones to buy.
6. As a customer, I want to be able to see the games price on the browse page,
such that I would see the game price beforehand.
7. As a customer, I want to be able to search for a game, such that I could
purchase it.
8. As a customer, I want to see the recommended and minimum specifications for
the games, such that I could check if it is compatible with my machine.
9. As a customer, I want to be able to add or remove games to/from a shopping
cart, such that I could continue shopping.
10. As a customer, I want to be able to see and purchase the games in the
shopping cart at once, such that I would not need to buy them separately.
11. As a customer, I want to be able to access my purchased games library, such
that I would have access to the game’s keys.
12. As an administrator, I want to be able to add new games, such that customers
could purchase them.
13. As a customer, I want to see the description of a game on its page, such that I
could get a grasp of what that game is about.
14. As an administrator, I want to be able to edit games information, such that the
games are up to date.
15. As a customer, I want to be able to see my profile information, such that I could
check if it is correct.
16. As a customer, I want to be able to change my password, such that my account
would be secure.
17. As a customer, I want to be able to change my information, such that I could
correct the mistakes.

**Low Priority**

18. As a customer, I want to see newly released games, such that I would be up to
date with new games.
19. As a customer, I want to see the IGN rating of games, such that I would have a
brief idea of how critics reviewed it.
20. As a customer, I want to see the ESRB rating of games, such that I can make
informed choices about which games are right for me.
21. As a customer, I want to be able to add or remove games to/from my Wishlist,
such that I can check them later.
22. As a customer, I want to be able to see my Wishlist, such that I could buy the
games later. 

## Non-Functional Requirements
23. Every game and user should be stored in the database server
24. The data between the client and the app server needs to be sent as a JSON
format.
25. Create a distributed system
26. The system must be heterogeneous
27. The system must contain server to server communication
28. The system must use at least two different network technologies
29. The system must include a GUI for each client
30. The system must have one or more databases
31. The system must use PayPal billing service 

## Project Future
Looking at the current finished project, first the Website graphic designed needs a big change because we have put all
of our effort in to functionality of it and were out of time to make it look pleasant to the eye, after that a few technical features could be improved. One
of the major ones would be to let a customer purchase a game without registering to
the system. The second one would be to let a user know if the game is out of stock, for
the reason that at this time the system only notifies the user that a game is out of stock
when trying to purchase it. Notifying beforehand would increase efficiency in the user
experience. In general, if looking at the future of this project, a sale functionality could
be added for the administrator, meaning that it would be possible to make a game go
on sale. Along with that, notify the customers who have the game on their Wishlist that
the game is currently on sale. Furthermore, a feature “Upcoming games” with a
countdown for each game until they are released and available to buy, would also be
useful for customers. In the case of scalability, the project is developed with an idea in
mind to be easily scalable. Database, which is used in the third tier is the only point that
would need to be upgraded in the system because currently it is hosted with small
available limits. After that, the system can be scaled to a vast extent. 

## Conclusion
The system was developed for making buying video games online possible. It
solves the main problem of current danger of shopping in a physical game store
because of the pandemic, struggle to find the desired title and limited stock along
with waiting queues for purchasing a new game. In addition, all the requirements
were implemented, and all the criteria was met. They were all tested and are
working. The application has a simple and scalable user interface, 3-tier
architecture, dependencies injection and MVVM design patterns. It uses REST
requests and sockets to communicate between tiers and uses technologies like
.NET, Blazor, C# and Java. 
