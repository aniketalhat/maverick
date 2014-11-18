package twitter4j.examples.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Paging;
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
		         .setOAuthConsumerKey("hT0ZtwZSKYb408iLOUO38w")
		         .setOAuthConsumerSecret("2gDRSPKDsdm2MX2rGny0jK8t8YfdiTZKxMiR7Nc82A")
		         .setOAuthAccessToken("296890880-urKZtaUymaf9HzJXlN4PzFV4mRzM9MyCmI6rw2mx")
		         .setOAuthAccessTokenSecret("vomL6G20pXzgLmb7UhXMPrmvbUhysu9jr3dwxggmJQ5Zu");
		        
		         Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	             User user = twitter.showUser(uname);
	        
	             if (user.getStatus() != null) {
		             System.out.println("Basic details of user on twitter");
		             System.out.println("Latest Status update: @" + user.getScreenName() + " - " + user.getStatus().getText());
		             System.out.println("Followers count: "+ user.getFollowersCount());
		             System.out.println("Friends count: "+ user.getFriendsCount());
		             System.out.println("Location: "+ user.getLocation());
		           
		             Paging paging = new Paging(2, 40);
		             List<Status> statuses = twitter.getHomeTimeline(paging);
		             
		             System.out.println("Showing home timeline.");
		             for (Status status : statuses) {
		             	System.out.println(status.getUser().getName() + ":" +status.getText());
		             	}
		             }
	            else {
	                // the user is protected
	                System.out.println("@" + user.getScreenName());
	            }
	            
	        } 
	      catch (TwitterException te) {
	            te.printStackTrace();
	       }
    }
}
