
### Dependency Diagram

```mermaid
%%{
  init: {
    'theme': 'neutral'
  }
}%%

graph TOP_BOTTOM

  subgraph core
    common
    feature_api
  end
  subgraph movie
    data
    domain
  end
  subgraph movie_details
    data
    domain
  end
  app --> ui
  app --> domain
  app --> data
  app --> ui
  app --> domain
  app --> data
  app --> common
  app --> feature_api
  app --> ui
  app --> domain
  app --> data
  app --> ui
  app --> domain
  app --> data
  app --> common
  app --> feature_api
  app --> ui
  app --> domain
  app --> data
  app --> ui
  app --> domain
  app --> data
  app --> common
  app --> feature_api
  app --> ui
  app --> domain
  app --> data
  app --> ui
  app --> domain
  app --> data
  app --> common
  app --> feature_api

```