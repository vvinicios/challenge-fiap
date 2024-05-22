package br.com.fiap.studymatch.beans

class User {

    var username: String = ""
    var accountType: String = ""

    constructor(username: String, accountType: String){
        this.username = username
        this.accountType = accountType
    }
    constructor(apprentice: Apprentice){
        this.username = apprentice.username
        this.accountType = "Apprentice"
    }
    constructor(mentor: Mentor){
        this.username = mentor.username
        this.accountType = "Mentor"
    }
}