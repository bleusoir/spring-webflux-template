
# Spring WebFlux + R2DBC with Kotlin example



## Introduction

This project is a simple example of how to use Spring WebFlux and R2DBC with Kotlin. It provides a RESTful API for CRUD operations on a database table.

## Features

* Uses Spring WebFlux for reactive HTTP requests
* Uses R2DBC for reactive database access
* Provides a RESTful API for CRUD operations on a database table

## Usage

To use this project, clone it to your local machine and open the project directory in your favorite IDE.

**Prerequisites**

* Java 17 or later
* Kotlin 1.8.22 or later
* Gradle Kotlin DSL
* Database Server

### Table creation

The member table can be created using the following SQL statement:

```sql
CREATE TABLE member (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  age INT NOT NULL,
  created_at TIMESTAMP(3) NOT NULL,
  updated_at TIMESTAMP(3) NOT NULL
);
```
## Environment Variables

To run this project, you will need to add the following environment variables to your `application.yml` file

`R2DBC_URL`

`R2DBC_ID`

`R2DBC_PW`


## API Reference

#### Get all members

```http
  GET /members
```

#### Get member by name

```http
  GET /members/:memberName
```

| Path Variables | Type     | Description                  |
|:---------------|:---------|:-----------------------------|
| `memberName`   | `String` | **Required**. Name of member |

#### Save member

```http
  POST /members
```

|  Body  |   Type   |         Description          |
|:------:|:--------:|:----------------------------:|
| `name` | `String` | **Required**. Name of member |
| `age`  |  `Int`   | **Required**. Age of member  |

#### Update member by id

```http
  PUT /members/:memberId
```
| Path Variables | Type   | Description                |
|:--------------:|:-------|:---------------------------|
|   `memberId`   | `Long` | **Required**. Id of member |

|  Body  |   Type   |         Description          |
|:------:|:--------:|:----------------------------:|
| `name` | `String` | **Required**. Name of member |
| `age`  |  `Int`   | **Required**. Age of member  |

#### Remove member by id

```http
  DELETE /members/:memberId
```
| Path Variables | Type   | Description                |
|:--------------:|:-------|:---------------------------|
|   `memberId`   | `Long` | **Required**. Id of member |

## License

[MIT](https://choosealicense.com/licenses/mit/)


## Contributing

If you would like to contribute to this project, please create a pull request with your changes.