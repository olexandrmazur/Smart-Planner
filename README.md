# Smart-Planner

![image](https://github.com/user-attachments/assets/666d2dba-df19-4554-a157-20ffaf91ea86)

---

**📖 Project overview:**

SmartPlanner was created to help people better manage their time, tasks, and goals in a fast-paced world. It was designed to be more than just a calendar – it is a assistant that helps users stay organized, reduce stress, and boost productivity. With SmartPlanner, users can easily plan their days, track their deadlines, and balance school, work, volunteering, and personal life all in one place. Its goal is to support users in building healthy habits, staying motivated, and achieving their dreams step by step. It offers the following functionality:

Sign up, log in, delete and edit user`s account

Create, delete, view, edit events

**Events** has next properties:

- ID of event
- ID of organizator
- Title of event
- Content
- Date of excecution
- Time
- location
- importancy of the event
- color that will be lighted in calendar

**User** has next fields:

- ID that user receive from system
- Name
- Login
- Password

---

**🛠️ Used Techonologies:**

- **Backend:**
  - Java 23
  - JDBC – for working with the database
  - HTTP Server – own implementation or use of the built-in HTTP server
  - Telegram API - it is framework for working with telegram bots.
- **Frontend:**
  - HTML for creating elements
  - CSS for scaling HTML elements
  - JavaScript for creating web logic sending requests and validation of data

- **Additional libraries:**

  - gson-2.8.9.jar it is library for working with json
  - mysql-connector-j-9.2.0.jar it is driver for connecting to the mysql database
  - telegrambots it is a library for working with telegram bots
  - Logback Classic is a library for telegrambots it is logging processes into console or .log file

---

**🔧 How to launch project on local machine:**

- You need to download folder profect or fork repository and open it on your IDE(eclipse/VS code/IDEA)
- If you want to connect planner to the local database you have to change java class Database.java
