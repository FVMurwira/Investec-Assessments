package models;

import java.util.List;

public class People {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<Object> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People withName(String name) {
        this.name = name;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public People withHeight(String height) {
        this.height = height;
        return this;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public People withMass(String mass) {
        this.mass = mass;
        return this;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public People withHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public People withSkinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public People withEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public People withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public People withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public People withHomeworld(String homeworld) {
        this.homeworld = homeworld;
        return this;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public People withFilms(List<String> films) {
        this.films = films;
        return this;
    }

    public List<Object> getSpecies() {
        return species;
    }

    public void setSpecies(List<Object> species) {
        this.species = species;
    }

    public People withSpecies(List<Object> species) {
        this.species = species;
        return this;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public People withVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public People withStarships(List<String> starships) {
        this.starships = starships;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public People withCreated(String created) {
        this.created = created;
        return this;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public People withEdited(String edited) {
        this.edited = edited;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public People withUrl(String url) {
        this.url = url;
        return this;
    }

}