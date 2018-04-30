# MTG
Magic The Gathering android app in MVP architecture

This is an android app that displays Magic The Gathering Sets, Cards and Boosters. It consumes the <a target="_blank" href="https://magicthegathering.io/">MTG Developers API.</a> The application's architecture follows the Model-View-Presenter design pattern and is divided into 4 modules:

 - app - Contains the UI components of the app and the root of the dependency injection.
 - presentation - Contains presenter classes that obtain data from repositories, process and pass it to the views
                  as well as handling and processing view events and logic.
 - data - Contains the implementation of the data sources (repositories) used in the app, both api and local db.
 - domain - Contains interfaces of the repositories and models used throughout the app.

### Screenshots
<img src="https://raw.githubusercontent.com/owuor91/MTG/master/images/sets.png" width="260"> <img src="https://raw.githubusercontent.com/owuor91/MTG/master/images/cards.png" width="260"> <img src="https://raw.githubusercontent.com/owuor91/MTG/master/images/card.png" width="260">

### Pull the project
    git clone https://github.com/owuor91/MTG.git
    cd mtg

## Libraries Used:
### General
 - [Dagger2](https://google.github.io/dagger/) - Dependency Injection framework
 - [RxJava](https://github.com/ReactiveX/RxJava) - Asynchronous event-based reactive streams
 - [RxAndroid](https://github.com/ReactiveX/RxAndroid) - Android bindings for RxJava
 - [Crashlytics](https://fabric.io/kits/android/crashlytics) - Crash reporting

### View
 - [Butter Knife](http://jakewharton.github.io/butterknife/) - View binding

### Network
 - [Retrofit](http://square.github.io/retrofit/) -HTTP requests
 - [Gson](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - Json serialization and deserialization

### Database (WIP not yet merged to master)
 - [Room](https://developer.android.com/topic/libraries/architecture/room.html) - Local SQLite ORM

### Testing
 - [Mockito](http://site.mockito.org/) - Unit testing framework

