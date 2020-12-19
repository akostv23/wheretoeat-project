# Where to eat?

Hey guys, this year isn’t about going to restaurants, meanwhile we can explore some of
them at home and make an order, to get some good food and let our home made “specialties”
rest a while. According to this we will do a little app as a project during Android courses, where
we can explore restaurants and expand the data we have from the ​ **BE** ​with our experience.
The goal is to have an app which works (those apps that are crashing or can’t be built are
not accepted) well, we can have a profile, a local database where we can persist our experience,
get data from the BE as mentioned, list it, review it one by one.
What we need and what is mandatory:

- Screens:
    1. Splash(Loading/Start) Screen
    2. Main Screen - with the restaurant’s list, paginated
    3. Detail Screen - each restaurant has its own page, that can be accessed
       from the list item, when you tap it
    4. Profile Screen
- Components that you have to use:
    1. Activity (max two)
    2. Fragments
    3. Recycler View
    4. Room and/or SQLite
    5. Constraint Layout
    6. Retrofit
    7. Glide
The design and UX is on you, just make sure, that is sample, shiny and usable, you
Android basic design components and colours.

## Splash(Loading/Start) Screen

Here you can have a loading, where data is initialised, based on the profile section and
when the user gets from here to Main Screen, the data is already loaded.

## Main Screen

Here we have the main list with the restaurants, paginated. You can do text search or
filtering by Favorited data, City list, Price options. Each item has to have: Title, Address, Image,
Price, Favourite icon (with this you can favourite it in/out).

## Detail Screen

On the detail page you can view all the details of what ​ **BE** returned and edit it according to
the possibilities. These possibilities are: Favourites, Add/Delete Images. Other things: open


Google Maps with the coordinates of the restaurant, call the place.
Regarding displaying the images (at all the options in the app), if you have added your own
ones, then they are prioritised and those should be displayed instead of the ones from BE. In the
case when you have not added images by your own, then display BE image or if not exists then a
placeholder.

## Profile Screen

```
Here you can manage your own profile, what has to contain:
```
- Name
- Profile pic
- Address
- Phone number
- Email
- List of Favourites restaurants
**Side notes:**
1. You need to use ROOM or SQLite to save local data.
2. In case you are not using BE component you have to create the whole structure of the
data and have possibility to add/remove/edit these (restaurants)
