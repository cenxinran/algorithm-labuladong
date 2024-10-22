package b_00_hexinkuangjia.b_004_erfensousuo;

/**
 * @className: Solution002NthUglyNumber
 * @author: Docer
 * @date: 2024/10/22 11:18
 * @Version: 1.0
 * @description: 1201. 丑数 III
 */
public class Solution002NthUglyNumber {
    public static void main(String[] args) {
        Solution002NthUglyNumber solution002NthUglyNumber = new Solution002NthUglyNumber();
        System.out.println(solution002NthUglyNumber.nthUglyNumber(5, 2, 3, 3)); // 8
        System.out.println(solution002NthUglyNumber.nthUglyNumber(1000000000, 2, 217983653, 336916467)); // 1999999984
    }

    // 寻找第 n 个丑数
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1, right = (int) 2e9;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (n > f(mid, a, b, c)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 返回 [1,n] 之间，且是 abc 任意一个数的倍数的数的个数
    private long f(int n, int a, int b, int c) {
        long setA = n / a;
        long setB = n / b;
        long setC = n / c;
        long setAB = n / lcm(a, b);
        long setBC = n / lcm(b, c);
        long setAC = n / lcm(a, c);
        long setABC = n / lcm(lcm(a, b), c);
        return setA + setB + setC - setAB - setBC - setAC + setABC;
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公约数：辗转相除算法
    private long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
