package com.Evaluacion1.threads;

public class Theory_1 {
    public static void main(String[] args) {
        Theory_1_1_Father father = new Theory_1_1_Father();
        Theory_1_1_Child child = new Theory_1_1_Child();
        Theory_1_1_Child2 child2 = new Theory_1_1_Child2();

        father.setSurname("Fernandez");
        System.out.println("No tengo nombre pero mi apellido es " + father.getSurname());

        child.setName("Paco");
        child.setSurname("Fernandez");
        System.out.println("Me llamo " + child.getName() +
                           " y mi apellido es " + child.getSurname());

        child2.setSurname("Fernandez");
        System.out.println("HOLA MI APELLIDO ES " + child2.getSurname());


        Theory_1_2_Square sq = new Theory_1_2_Square(3);
        Theory_1_2_Triangle tr = new Theory_1_2_Triangle(1,2,3);

        System.out.println("Cuadrado perimetro: " + sq.getPerimeter() + "; " +
                           "area: " + sq.getArea());
        System.out.println("Triángulo perimetro: " + tr.getPerimeter() + "; " +
                           "area: " + tr.getArea());
    }
}

class Theory_1_1_Father {
    String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }
}
class Theory_1_1_Child extends Theory_1_1_Father {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Theory_1_1_Child2 extends Theory_1_1_Father {
    @Override
    public String getSurname() {
      return surname.toUpperCase();
    }
}

interface Theory_1_2_Figure {
    public double getArea();
    public double getPerimeter();
}
class Theory_1_2_Square implements Theory_1_2_Figure {
    int side;

    public Theory_1_2_Square(int side) {
        this.side = side;
    }
    
    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }
}
class Theory_1_2_Triangle implements Theory_1_2_Figure {
    int base, height, side3;

    public Theory_1_2_Triangle(int base, int height, int side3) {
        this.base = base;
        this.height = height;
        this.side3 = side3;
    }

    public double getArea() {
        return (base + height) / 2;
    }

    @Override
    public double getPerimeter() {
        return base + height + side3;
    }
}