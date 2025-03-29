# Sandwich Maker Game Project 

## Project Description - What is my Project?    

Hello and welcome to my Sandwich Maker Game. This project will be about a game where you are able to costumize your own sandwich. The gameplay will involve the player being able to pick the ingredients/filling for their sandwich, and personalize the qualities regarding each of the ingredients in their sandwich.  

## Project Description - Who Will Use my Project?  

Although my project can be played by anyone, my main target audience are:  
- Kids from the age 7 to 12.  
- Teenagers from the age 13 to 18.  

## Project Description - Why Make a Sandwich Simulator Game?  

I chose to make a sandwich simulator game for my project since I have always enjoyed playing restaurant/cooking simulation games when I was little. In fact, even now, I still enjoy a lot of restaurant simulator games such as **Overcooked 2**. Consequently, I want to make my project around the idea of restaurant simulator games out of passion and my love for the genre.  

## User Stories    


- As a user, I want to be able to add ingredients to a sandwich.  
- As a user, I want to be able to view a list of all ingredients in the current sandwich I am making.  
- As a user, I want to be able to view the properties for each of the ingredients in the current sandwich.   
- As a user, I want to be able to select the properties for different ingredients.  
- As a user, I want to be able to remove an ingredient from a sandwich.  
- As a user, I want to be able to save my current sandwich to file (if I so choose).  
- As a user, I want to be able to load my current sandwich from file (if I so choose).  


# Instructions for End User

- You can generate the first required action (Removing Ingredients) related to the user story "adding multiple Xs to a Y" by clicking the Remove button.  
- You can generate the second required action (checking the quality for the ingredients) related to the user story "adding multiple Xs to a Y" by clicking the view ingredients button.  
- You can add ingredients to a sandwich by pressing either the add bacon or add pickle buttons.  
- You can select the properties for different ingredients by clicking the add bacon/add pickle buttons and inputting a number that correspond to the property.  
- You can view all the ingredients in the sandwich by the display in the panel.  
- You can locate my visual component by the display in the panel after you added or loaded the ingredients in the sandwich.  
- You can save the state of my application by pressing the save sandwich button.  
- You can reload the state of my application by pressing the load sandwich button.  

## Phase 4: Task 2  
- Welcome to my sandwich simulator game project!  
- Fri Mar 28 14:21:55 PDT 2025  
- Dill Pickle Added.  
- Fri Mar 28 14:21:58 PDT 2025  
- Cooked Bacon Added.  
- Fri Mar 28 14:22:03 PDT 2025  
- Cooked Bacon Added.  
- Fri Mar 28 14:22:05 PDT 2025  
- Ingredient List Viewed.  
- Fri Mar 28 14:22:09 PDT 2025  
- Ingredient Removed.  

## Phase 4: Task 3  

After working through my UML class diagram for this project, I came to realize that if I had more time to work on the project, I could have done a lot more refactoring to a lot of my classes, in order to prove the design of my project. For example, one refactoring that I might use to improve enforce the Single Responsibility Principle for some of my classes, such as my SandwichGame and SandwichGameGui class. In the original console ui class for SandwichGame, I felt like the class was mostly organized; however, in the SandwichGameGui class, I came to realize that I am putting a lot of different responsibilities into that class after completing my UML diagram and reflecting upon the design of my program. For instance, I definitely could have made another class that handled all of the functionalities of the sandwich game, such as adding ingredients. While kept the SandwichGameGui class to focusing on only making the GUI aspect, namely the JPanels and the buttons, instead of handling both aspects of the game and the graphics. I felt that this refactoring would be a strict improvement to the design of my code as it will increase the cohesion of my project.  



