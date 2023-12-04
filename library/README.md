# library
 Getting Started

open jdk 21 used
no data repositories are used

to start service run LibraryApplication.class 

apis:-POST http://localhost:8080/api/books
Content-Type: application/json

{
"bookName": "wer",
"bookAuthor": "rbiyuiohn",
"publicationYear": "2023"
}


//////
###
PUT http://localhost:8080/api/books?id=1
Content-Type: application/json


{
"bookName": "book8",
"id": 1,
"bookAuthor": "sarita",

###########
GET http://localhost:8080/api/books
