package br.com.fiap.studymatch.retrofit

import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @POST("/mentor")
    fun createMentor(mentor: Mentor) : Call<Mentor>

    @POST("apprentice")
    fun createApprentice(apprentice: Apprentice) : Call<Apprentice>

    @GET("mentor")
    fun getMentors() : Call<List<Mentor>>

    @GET("mentor/{username}")
    fun getMentorsByUsername(@Path("username") username: String) : Call<Mentor>

    @GET("mentor/{areaOfInterest}/{experienceTime}")
    fun getMentorWithAdvancedSearch(@Path("areaOfInterest") areaOfInterest: String, @Path("experienceTime") experienceTime: String): Call<List<Mentor>>

    @GET("apprentice")
    fun getApprentice(): Call<List<Apprentice>>

    @GET("apprentice/{username}")
    fun getApprenticeByUsername(@Path("username") username: String): Call<Apprentice>

    @GET("apprentice/{areaOfInterest}/{experienceTime}")
    fun getApprenticeWithAdvancedSearch(@Path("areaOfInterest") areaOfInterest: String, @Path("experienceTime") experienceTime: String): Call<List<Apprentice>>

    @POST("MentorChosen")
    fun createMentorChosen(mentor: Mentor, apprentice: Apprentice) : Call<Apprentice>

    @POST("ApprenticeChosen")
    fun createApprenticeChosen(apprentice: Apprentice, mentor: Mentor) : Call<Mentor>

    @GET("MentorChosen")
    fun getMentorChosenList(mentor: Mentor) : Call<List<Apprentice>>

    @GET("AppenticeChosen")
    fun getApprenticeChosenList(apprentice: Apprentice) : Call<List<Mentor>>

    @GET("MatchsMentor")
    fun getMatchsMentor(username: String) : Call<List<Apprentice>>

    @GET("MatchsApprentice")
    fun getMatchsApprentice(username: String) : Call<List<Mentor>>




}