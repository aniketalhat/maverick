package twitter4j.examples.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
public final class ShowUser {
      public static void main(String[] args) throws IOException {
        ConfigurationBuilder cb;
      try {
        	 System.out.print("Enter username: ");
        	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             String uname = reader.readLine();
        	
            cb = new ConfigurationBuilder(); 
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("tAktgPVHCMtR0VNL712YmA")
        	  .setOAuthConsumerSecret("z1U5v7diFTcI8C28nb4gyiCDiK7bMgEy17LQo7Nqr4")
        	  .setOAuthAccessToken("296890880-z9rtkCwNk3oySJpmYoCo5ny3GpSNTBpThDTz4GFr")
        	  .setOAuthAccessTokenSecret("VY7zFoJ5CNTpSLRQ5rLHk4BzUG3HJnabP4SgcTeCil8");
        	
        	Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        	
        	User user = twitter.showUser(uname);
            if (user.getStatus() != null) {
            	System.out.println("Basic details of user on twitter");
            	System.out.println("Latest Status update: @" + user.getScreenName() + " - " + user.getStatus().getText());
            	System.out.println("Followers count: "+ user.getFollowersCount());
            	System.out.println("Friends count: "+ user.getFriendsCount());
            	System.out.println("Location: "+ user.getLocation());
            
            	System.out.println("Enter the tweet id (exp: 266031293945503744): ");
            	String rid=reader.readLine();
            	
            	Status status = twitter.showStatus(Long.parseLong(rid));
            	System.out.println("User: @"+status.getUser().getScreenName()+" Score: " + status.getRetweetCount()+ " Status: " + status.getText());
              System.exit(0);
              System.out.println("done.");
              System.exit(0);
            	} 
            else {
                // the user is protected
                System.out.println("@" + user.getScreenName());
            }
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to delete status: " + te.getMessage());
            System.exit(-1);
        }
    }
}
