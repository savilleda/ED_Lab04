package ed.lab;

public class Main
{
    private static final ArrayGenerator<String> sortedArrayGenerator = length ->
    {
        String[]array = new String[length];
        int width = String.valueOf(Math.max(0, length - 1)).length();
        for(int i = 0; i<length; i++)
        {
            array[i] = formatIndex(i, width);
        }
        return array;
    };
    private static final ArrayGenerator<String> invertedArrayGenerator = length ->
    {
        String[]array = new String[length];
        int width = String.valueOf(Math.max(0, length - 1)).length();
        for(int i = 0; i<length; i++)
        {
            array[i] = formatIndex(length - 1 - i, width);
        }
        return array;
    };
    private static final ArrayGenerator<String> randomArrayGenerator = length ->
    {
        String[]array = new String[length];
        int width = String.valueOf(Math.max(0, length - 1)).length();
        java.util.Random random = new java.util.Random();
        for(int i = 0; i<length; i++)
        {
            array[i] = formatIndex(random.nextInt(length), width);
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;

    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;

    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;
    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
      }

    private static String formatIndex(int value, int width) {
        return String.format("%0" + width + "d", value);
    }
}
