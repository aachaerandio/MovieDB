# MovieDB
Demo app that shows the top 20 most popular movies (Movies, TV Shows and People) 
-Using MovieDB Api http://docs.themoviedb.apiary.io/

## Table of Contents
* [Libraries Used](#libraries-used)
* [Known Issues](#known-issues)
* [Future Improvements](#future-improvements)

## Libraries Used
- Retrofit 2.0 (Annotated REST Client)
- Picasso (load images)
- JUnit (Unit Testing)
- Gradle (Task & dependency management)

## Known Issues
- Back button in detail takes you to the default tab.
  - Action: Remember the tab the user comes from
- Missing calendar Icon in Movie list (Unicode \uD83D\uDCC5 produces an exception on some android devices)
- Settings doesn't do anything (no design / requirements provided)

## Future Improvements
- Implement search within categories.
- Improve detail layout.
- Reduce amount of calls.
  - 1-day cache using OkHttp client caching options which also serves as Offline mode.
- Tablet / Grid Layout compatibility.

