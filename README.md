# Student-api
CRUD api using java and using MySQL database

## API Endpoints

GET `/`
- get all students in the database
- *Example response:*  
```
[
{
"id": 3,
"name": "Ali",
"dateOfBirth": "1995-08-08",
"email": "ali@gmail.com",
"age": 25
},
{
"id": 4,
"name": "Ahmed",
"dateOfBirth": "1997-08-07",
"email": "ahmedtrk@gmail.com",
"age": 23
}
]
```

POST `/`
- add a new student to the database
- *Request body:* {

"name": "Ahmed",
"dateOfBirth": "1997-08-07",
"email": "ahmedtrk@gmail.com"

}

DELETE `/<student_id>`
Delete an existing student
- *Request arguments:* syudent_id:int 
- *Example response:* 
```
{
  "deleted": "28", 
  "success": true
}
```

