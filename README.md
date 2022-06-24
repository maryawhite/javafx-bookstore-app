# JavaFX Bookstore Desktop Application

**Credit to Mike Møller Nielsen from Java Code Geeks on Youtube, https://youtu.be/RDvAx1_rIxk for this great tutorial.**

I'm running this on a Macbook Pro Monterey and IntelliJ 2021.2

One issue I have on the Mac is the font doesn't display properly. I used -fx-font-family in a few places to get the font to display. For example, <code>overviewScene.getRoot().setStyle("-fx-font-family: Serif;");</code> And for the alerts for example <code>alert.getDialogPane().setStyle("-fx-font-family: Serif");</code> Windows users might not need to do this. 

The error message looked like this <code>CoreText note: Client requested name ".SFNS-Regular", it will get Times-Roman rather than the intended font. All system UI font access should be through proper APIs such as CTFontCreateUIFontForLanguage() or +[NSFont systemFontOfSize:].</code>

The tutorial uses logger which I'm not familiar with.  I used a System.out.println in places where the tutorial used the logger. 
