class MobileApp {
  interface Notification {
      void sendNotification();
  }
}

class EmailNotification implements MobileApp.Notification {
  @Override
  public void sendNotification() {
      System.out.println("Email notification sent!");
  }
}

public class mob {
  public static void main(String[] args) {
      EmailNotification emailNotification = new EmailNotification();
      emailNotification.sendNotification();
  }
}