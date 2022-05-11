package com.example.stickyheaderrecyclerviewapp;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_PERSON = 1;

    public static List<String> alphabet_available = new ArrayList<>();

    /*
     * Funtion to sort person list name by alphabet
     * */
    public static ArrayList<Person> sortList(ArrayList<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });
        return people;
    }
    /*
     * After sorted, this function will add alphabet character to list
     * */

    public static ArrayList<Person> addAlphabets(ArrayList<Person> list) {
        int i = 0;
        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEWTYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0))); //Add first character to group header
        customList.add(firstPosition);//Add first character to group header list
        for (i = 0; i < list.size() - 1; i++) {
            Person person = new Person();
            char name1 = list.get(i).getName().charAt(0);//get first character in name
            char name2 = list.get(i + 1).getName().charAt(0); //too
            if (name1 == name2) {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
            } else {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEWTYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);
            }
        }
        list.get(i).setViewType(VIEWTYPE_PERSON);
        customList.add(list.get(i));
        return customList;
    }

    /*
     * This funtion return position of string in list
     * */
    public static int findPositonWithName(String name, ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            return i;
        }
        return -1;
    }

    /*
     * This funtion generate an Alphabet List
     * */
    public static ArrayList<String> genAlphabet() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {//65 in ASCII code = A, 90 = Z
            char character = (char) i;
            result.add(String.valueOf(character));
        }
        return result;
    }


    /*
     * This funtion create an Person group with random name
     * */
    public static ArrayList<Person> genPeopleGroup() {
        ArrayList<Person> peopleList = new ArrayList<>();
        Person person = new Person("Andy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Bndy", "Rirection", -1);
        peopleList.add(person);
        person = new Person("Cooondy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Fndy", "Laywer", -1);
        peopleList.add(person);
        person = new Person("Hndy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Andy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Jayden", "Laywer", -1);
        peopleList.add(person);
        person = new Person("Andy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Bndy", "Laywer", -1);
        peopleList.add(person);
        person = new Person("Bndy", "Direction", -1);
        peopleList.add(person);
        person = new Person("Bummmndy", "Direction", -1);
        peopleList.add(person);

        return peopleList;
    }
}
