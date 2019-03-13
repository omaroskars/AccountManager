# AccountManager
Simple REST API written in Java spring for user accounts.

Login to see available resources
```
username: admin
password: admin
```
then navigate to `http://localhost:8080/swagger-ui.html`

#### Issues
Spring security was giving me some troubles regarding CSRF tokens.
To test/extend POST and PUT methods you need to disable authentication and CSRF.

in ManagerApplicatoin.java disable CSRF:
```
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
  }
```

I have a WIP [pull request](https://github.com/omaroskars/AccountManager/pull/2)  implementing authentication/autorization with oauth.
or checkout to the branch `git checkout feature/oauth`
