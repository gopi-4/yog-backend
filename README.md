## YOGI BackEnd
  - Backend to perform CRUD operations. 
  - user gets registered only if he/she is not registered for the given month eles it gives error. 
  - For specific user email it gives error of payment fail.
  - On registering the user for the present month for the first time, past entry of the user get deleted. 

## Schema Description
### User
| Attribute | Type | Nullable | Description |
| :--- | :--- | :--- | :--- |
| Id | Integer | NO | Primary Key |
| name | String | NO | User name |
| email | String | NO | User email |
| dob | String | NO | YYYY/MM/DD |
| phone | String | YES | 10 digits mobile no. |
| slot | String | NO | 1, 2, 3 or 4 |
| registration_date | String | NO | date at which user registered |
| payment_status | Boolean | NO | payment status |

## API Description

### Base URL : https://yog-backend-production.up.railway.app

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/9a7f96e52b0831af3cb2?action=collection%2Fimport)

### 1. `/api/getUsers`
- `GET`: Get all user

### 2. `/api/registerUser`
- `POST`: Create a new user
    - Request Body:
        | Parameter | Type | Required | Description |
        | --------- | ---- | -------- | ----------- |
        | name | string | yes | user name |
        | email | string | yes | unique email |
        | phone | string | No | 0-10 digits long |
        | dob | string | yes | YYYY/MM/DD Format |
        | slot | string | yes | 1, 2, 3 or 4 |
        
## Tech Stack

<img src="https://img.shields.io/badge/SpringBoot%20-%2320232a.svg?logo=spring" >
 
## ER Diagram
![ERD](https://user-images.githubusercontent.com/78689282/206994144-dc060b49-b33b-40dd-ab62-ed54cc637ed5.jpg)

 ## Getting Started 
### Setup the repository to your local environment.

  ```git
  Fork repo
  git clone https://github.com/gopi-4/yog-backend.git
  cd yog-backend
  ```
  ## Setup
  ```
  install java version 8 and above
  run YogiApplication class
  ```
  
## Authors

- [@ganeshKalyankar](https://github.com/gopi-4)

 <center> <p align="center">--- Enjoy Coding --- </p></center>
