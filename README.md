# AccountManager
Simple REST API written in Java spring for user accounts.

Select your favourite IDE and start the application.
I use VS code with Spring boot dashboard.

Login to see available resources
```
username: admin
password: admin
```
then navigate to `http://localhost:8080/swagger-ui.html`

#### Issues
Spring security was giving me some troubles regarding CSRF tokens.
To test/extend POST and PUT methods you need to CSRF.

in ManagerApplication.java disable CSRF:
```
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
  }
```

I have a WIP [pull request](https://github.com/omaroskars/AccountManager/pull/2)  implementing authentication/autorization with oauth.
or checkout to the branch `git checkout feature/oauth`
