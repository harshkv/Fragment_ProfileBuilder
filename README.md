# Fragment_ProfileBuilder

Built an Android Application using a single Main Activity and multiple fragments. The Fragments communicate between other Fragments and Activity.Information is saved using SharedPreferences. 

The application enables a new student to enter and edit their information, and save it using shared preferences making use of three fragments namely: My Profile (main screen), Select Avatar, and Display My Profile.

When the app starts, check if there is any profile already saved in SharedPreferences. If there is already a profile saved in the SharedPreferences, load the saved profile and Display My Profile Screen. Else, load My Profile Screen.
