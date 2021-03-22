public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(Box<T> src, Box<? super T> dest) {
        dest.set( src.get() );
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static void copyFreshFruitFromBoxToBox(Box<Fruit> src, Box<? super Fruit> dest) {
        dest.set( src.get() );
    }

    //вывести в консоль (toString()) объект второй коробки
    public static <T> void printElementFromTwoBoxes(Box<Box<T>> box) {
       System.out.println( box.get().get().toString() );
    }

    /**
     * вывести в консоль (toString()) объект последней коробки
     *
     * box Box, которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
     */
    public static <T> void printElementFromBoxes(Box<T> box) {
        System.out.println( GetLastBox( box ).get() );
    }

    private static Box<?> GetLastBox( Box<?> box ) {
        Object inBox = box.get();
        return inBox instanceof Box ? GetLastBox((Box<?>) inBox) : box;
    }
}
