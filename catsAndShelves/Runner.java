public class Runner {

    // Cats and shelves

    //    Input
    //    Start and finish shelf numbers (always positive integers, finish no smaller than start)
    //
    //    Task
    //    Find the minimum number of jumps to go from start to finish
    //
    //    Example
    //    Start 1, finish 5, then answer is 2 (1 => 4 => 5 or 1 => 2 => 5)


    public static void main(String[] args) {
        int result = solution(1, 5);
        System.out.println(result);
    }

    public static int solution(int start, int finish)
    {
        int difference = finish - start;
        return (difference / 3) + (difference % 3);
    }
}
