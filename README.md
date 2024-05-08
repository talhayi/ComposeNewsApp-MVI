# NewsApp(Jetpack Compose)
This project is an Android mobile application built on top of news data provided by NewsAPI.org. 
The app is developed using the MVI architecture with Clean Architecture principles. 
It also incorporates popular Android technologies such as Jetpack Compose for UI development, Navigation, Dagger Hilt, Retrofit, Room, Coil, Datastore and Paging3.

## Features
- **Home Page:** Lists 15 latest news using Paging3. Each news item contains information like image, author, title, and description. When a news item is clicked, it is saved to the Room database.
- **Search Page:** Lists relevant news based on search queries. Search results also include image, author, title, and description similar to the home page.
- **Favorites Page:** Lists favorite news saved in the Room database. Access to favorite news is provided through this page.
- **Detail Page:** Navigates to a detailed page when a news item is clicked. This page provides more in-depth information about the selected news, including additional details and content.

- ##  Important Libraries in Project

|Library Name|Version Number|
|------------|--------------------------|
|Retrofit |2.9.0|
|Hilt |2.48.1|
|Lifecycle |2.6.2|
|Navigation	Component |2.7.6|
|Coroutines |1.7.1|
|Room |2.6.1|
|Coil |1.3.2|
|Paging3 |3.2.1|

## Images in NewsApp

<img src = "https://github.com/talhayi/NewsApp/assets/56438103/f9d9571f-fd2d-48c8-a0ab-f9f996910fcd.jpeg" width="250" height="500">  
<img src = "https://github.com/talhayi/NewsApp/assets/56438103/2f95e9e6-5436-4828-8983-4c8a39975c05.jpeg" width="250" height="500">
<img src = "https://github.com/talhayi/NewsApp/assets/56438103/2f59664f-1221-40b5-b6c2-17063923124f.jpeg" width="250" height="500">  
<img src = "https://github.com/talhayi/NewsApp/assets/56438103/64d7bdfa-9bf6-47ed-92df-525f68f9c0e0.jpeg" width="250" height="500">  
<img src = "https://github.com/talhayi/NewsApp/assets/56438103/861c997e-b7a3-4794-991b-9ad5ca02e167.jpeg" width="250" height="500">  
