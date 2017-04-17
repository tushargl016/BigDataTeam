import tweepy
import csv
import sys

consumer_key = 's0Cv5fCmINzHVt25stcEmo3Et'
consumer_secret = '4aITBDSdlNIuY9HAl9H1sQ6GqBt9jwjg4vZNwDu7sL2flnM9wh'
access_token = '853049789138825216-fGbaqTnWxCeUSoBEF5DeGXYz44IEnP1'
access_token_secret = 'pDgCIIvpinOSQfneV5KKHZ9uR0kJfRPRyZPnBMg5JHZzw'

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth)

# Open/Create a file to append data
csvFile = open('r.csv', 'wb')
#Use csv Writer
csvWriter = csv.writer(csvFile)


for tweet in tweepy.Cursor(api.search,q="#Fateofthefurious",count=10000,\
                           lang="en",\
                           since_id=2014-06-12).items():
    print tweet.created_at, tweet.text.encode("utf-8")
    csvWriter.writerow([tweet.created_at, tweet.text.encode('utf-8'),tweet.geo])