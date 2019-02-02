# WebFinder

Java spring boot application


# DB credentials

Store DB credentials in environment variables
 - spring_datasource_url
 - spring_datasource_username
 - spring_datasource_password
 
# Push local DB to heroku
 - Reset database on heroku 
    - heroku pg:reset --app eddgarcia
    
 - Push local database to heroku
    - set PGUSER=pgusername
    - set PGPASSWORD=pgpwd
    - heroku pg:push webfinder postgresql-fluffy-76550 --app eddgarcia
