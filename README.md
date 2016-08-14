# notifications

This library provides a central "notification manager" to enable users to send various types of messages:

1. Email

2. Text

3. Tweet (coming soon)

# Installation
- Clone the latest version of the code from github 
- Set up email.properties and text.properties found under src/main/java/resources/properties.

  - 2 template files have been provided as samples, fill in the necessary values and save as email.properties and text.properties
- Run the attached test class : NotificationTester.java
  - You should see something like the below:
  
    18:21:25.437 [main] INFO  com.bubblewrap.notifications.NotificationManager - Loaded property file: email.properties
    
    18:21:25.437 [main] INFO  com.bubblewrap.notifications.NotificationManager - Loaded property file: text.properties
    
    18:21:25.437 [Thread-3] INFO  com.bubblewrap.notifications.Notifier - Starting TEXT notifier
    
    18:21:25.437 [Thread-1] INFO  com.bubblewrap.notifications.Notifier - Starting EMAIL notifier
    
    18:21:25.437 [Thread-2] INFO  com.bubblewrap.notifications.Notifier - Starting PUSH notifier
    
    18:21:25.440 [main] INFO  com.bubblewrap.notifications.NotificationManager - Received new message: EMAIL
    
    18:21:25.440 [main] INFO  com.bubblewrap.notifications.NotificationManager - Received new message: TEXT
    
    18:21:27.273 [Thread-3] INFO  com.bubblewrap.notifications.utils.EmailUtils - Sent email to <phone-number>
    
    18:21:27.393 [Thread-1] INFO  com.bubblewrap.notifications.utils.EmailUtils - Sent email to <email-address>

    18:21:30.442 [main] INFO  com.bubblewrap.notifications.NotificationManager - Total messages processed: 2

    18:21:30.442 [Thread-1] INFO  com.bubblewrap.notifications.Notifier - Stopping EMAIL notifier, processed 1 messages
    
    18:21:30.442 [Thread-2] INFO  com.bubblewrap.notifications.Notifier - Stopping PUSH notifier, processed 0 messages

    18:21:30.442 [Thread-3] INFO  com.bubblewrap.notifications.Notifier - Stopping TEXT notifier, processed 1 messages
  
