package com.Evaluacion1.Objects;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /* ARRAYS
            Things to take in count:
                -We use primitive data types (String, int, etc).
                -We have to decide at the beginning the size of the Array.

        String[] paises = new String[3];

        paises[0] = "Spain";
        paises[1] = "France";
        paises[2] = "Italy";

        for(int i = 0; i < paises.length; i++) {
            System.out.println(paises[i]);
        }*/

        /* LISTS
            Things to take in count:
                -No max size write at the beginning.
                -Easiest to add new parameters between others.

        ArrayList<String> paises = new ArrayList<String>();

        paises.add("Spain");
        paises.add("France");
        paises.add("Italy");

        paises.add(2, "England");


        for(int i = 0; i < paises.size(); i++) {
            System.out.println(paises.get(i));
        }
        */

        /*  OBJECTS
            Things to take in count:
                -Can personalize the way we set and get the info.
                -Can save multiple primitive types.
                -Can be used with the others forms.

        Country country = new Country("Spain", "ESP", 40); //A singular country.
        ArrayList<Country> cList = new ArrayList<Country>(); //A list of countries.

        cList.add(country);
        cList.add(new Country("France", "FRA", 50));
        cList.add(1, new Country("Italy", "ITY", 38));

        for(int i = 0; i < cList.size(); i++) {
            System.out.println(cList.get(i).getCountry());
        }*/
    }
}
