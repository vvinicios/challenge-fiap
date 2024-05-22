package br.com.fiap.studymatch.functions

import android.annotation.SuppressLint
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.beans.User

@SuppressLint("SuspiciousIndentation")
fun findMatches(likedPairs: MutableList<Pair<Mentor, Apprentice>>): List<Pair<Mentor, Apprentice>> {
    val matches = mutableListOf<Pair<Mentor, Apprentice>>()
    for (pair in likedPairs) {
        val user1 = pair.first
        val user2 = pair.second
        // Logic for matching based on account type

            matches.add(user1 to user2)
    }
    return matches
}