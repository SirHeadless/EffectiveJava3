# Effective Java
## Item 1: Consider static factory method instead of constructor

__Example Code:__ This class can just be instantiated by the getInstance method. If the useless number is 1 or 2 it will not return a new object but will return the default objects CWSFMforUNone and  CWSFMforUNtwo.

```java
public class ClassWithStaticFactoryMethod {
    private static final ClassWithStaticFactoryMethod CWSFMforUNone = new ClassWithStaticFactoryMethod(5);
    private static final ClassWithStaticFactoryMethod CWSFMforUNtwo = new ClassWithStaticFactoryMethod(10);
    private static Map<Integer,ClassWithStaticFactoryMethod> somethingLikeACash
            = new HashMap<Integer, ClassWithStaticFactoryMethod>()
    {
        {
            put(1, CWSFMforUNone);
            put(2, CWSFMforUNtwo);
        }
    };

    private int uselessNumber;

    private ClassWithStaticFactoryMethod(int uselessNumber) {
        this.uselessNumber = uselessNumber;
    }

    public static ClassWithStaticFactoryMethod getInstance(int uselessNumber) {
        ClassWithStaticFactoryMethod instance = somethingLikeACash.get(uselessNumber);
        return instance != null ? instance : new ClassWithStaticFactoryMethod(uselessNumber);
    }

    @Override
    public String toString() {
        return "ClassWithStaticFactoryMethod{" +
                "uselessNumber=" + uselessNumber +
                '}';
    }
}
```

__Advantages:__

* The static factory method has a name
* The static factory method is not required to create a new object every time (see above)
* The static factory method can return any object of any subtype of their return type
* The class that is returned can vary from the input parameters
* The class of the returned object does not need to exist when the class containing the method is written

__Disadvantages:__

* Classes without public or protected constructors cannot be subclassed
* Hard for programmers to find

__Remark:__ Check in the book for examples how the static factory method can be called

## Item 2: Consider a builder when faced with many constructor parameters

__Problem:__ Static factories and constructor does not scale well to large numbers of optional parameters.

__Example:__ If you have for example a class representing the Nutrition Facts label (Nährwertkennzeichnung). This has a few necessary parameters and many optional.

__Alternative to builder patern:__

1. Telescoping constructor pattern: Provides multiple constructors with the following characteristics
* constructor with just necessary parameters
* constructor with necessary parameters and with one optional
* constructor with necessary parameters and with two optionals
* …

    __Disadvantages:__
    * Hard to read and write
    * There is not always a constructor for just the parameters you need

2. JavaBeans patter: You call a parameterless constructor to create the object and then you call setters to set each required and optional parameter.

    __Disadvantages:__
    * allows inconsistency between creating object and setting all parameters
    * mandates mutability

3. __Best solution:__ Builder pattern

    Instead of making the desired object directly, the client has a nested Builder class . The actual class has a private class has a private constructor so that the class can just be initialized by the nested Builder class.

    __Kotlin Example:__

    ```java
    public class NutritionFacts {
        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrit;
        private NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrit) {
            this.servingSize = servingSize;
            this.servings = servings;
            this.calories = calories;
            this.fat = fat;
            this.sodium = sodium;
            this.carbohydrit = carbohydrit;
        }
        public static class Builder {
            private final int servingSize;
            private final int servings;
            private int calories;
            private int fat;
            private int sodium;
            private int carbohydrit;
            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings = servings;
            }
            public Builder calories(int calories) {
                this.calories = calories;
                return this;
            }
            public Builder fat(int fat) {
                this.fat = fat;
                return this;
            }
            public Builder sodium(int sodium) {
                this.sodium = sodium;
                return this;
            }
            public Builder carbohydrit(int carbohydrit) {
                this.carbohydrit = carbohydrit;
                return this;
            }
            public NutritionFacts build(){
                return new NutritionFacts(servingSize, servings, calories, fat, sodium, carbohydrit);
            }
        }
    }
    ```

    __Disadvantages:__

    * You have to create a builder to greate an object what could be performance problem (but should not)
    * It is more verbose

## Item 3: Enforce the singleton property with a private constructor or an enum type

__Definition Singleton:__ A class that is instantiated only once.

__Possibilities:__

1. Singleton with public final field:

    ```java
    public class SingletonWithPublicFinalField {
        public static final SingletonWithPublicFinalField INSTANCE = new SingletonWithPublicFinalField();
        private static int numberOfInstantiations;
        private SingletonWithPublicFinalField(){
            numberOfInstantiations++;
            System.out.println("This SingletonWithPublicFinalField class was instantiated " + numberOfInstantiations + " times");
        }
        public void doSomething(){
            System.out.println("Object is doing something");
        }
    }
    ```

	In this approach the constructor is private and there is a public static final field member that 	provide access to the instance.

    __Advantages:__

    API makes it clear that the class is a singleton
    it is simpler

2. Singleton with static factory

    ```java

    public class SingletonWithStaticFactory {
        private static final SingletonWithStaticFactory INSTANCE = new SingletonWithStaticFactory();
        private static int numberOfInstantiations;
        public static SingletonWithStaticFactory getInstance() {
            return INSTANCE;
        }
        private SingletonWithStaticFactory() {
            numberOfInstantiations++;
            System.out.println("This SingletonWithStaticFactory class was instantiated " + numberOfInstantiations + " times");
        }
        public void doSomething(){
            System.out.println("Object is doing something");
        }
    }
    ```

    In this approach the constructor is private and there is a public static factory member that 	provide access to the instance.

    __Advantages:__
    you can change it so that is no a singleton without changing the API

3. A single-element enum type

    ```java
    public enum SingletonSingleElementEnum {
        INSTANCE;
        public void doSomething(){
            System.out.println("Object is doing something");
        }
    }
    ```

    It is the best and simplest way

    __Disadvantages:__ You can't use it if your singleton must extend a superclass other than Enum

__What to use:__
1. Single element Enum approach
2. public final field
3. static factory

## 4. Enforce noninstantiablitiy with a private constructor

__Problem__: A class that contains just static methods and static fields is not suppose to be instantiated. Anyway it can be instantiated.

__Solution__: Add a private default constructor to the class to make it noninstantiable

```java
public class NoninstantiableUtilityClass {

    // Suppress default constructor for noninstantiablity
    public static void utilityMethod() {
        System.out.println("Do some utility stuff");
    }

    private NoninstantiableUtilityClass() {
        throw new AssertionError();
    }
}
```

The AssertionError is not required, but it provides insurance in case the constructor is accidentally invoked from within the class.