package b_00_hexinkuangjia.b_004_erfensousuo;

/**
 * @className: Solution002NthUglyNumber
 * @author: Docer
 * @date: 2024/10/22 14:59
 * @Version: 1.0
 * @description: 1201. 丑数 III 超时
 */
public class Solution002NthUglyNumber_02 {
    public static void main(String[] args) {
        Solution002NthUglyNumber_02 solution002NthUglyNumber = new Solution002NthUglyNumber_02();
        System.out.println(solution002NthUglyNumber.nthUglyNumber(5, 2, 3, 3)); // 8
        System.out.println(solution002NthUglyNumber.nthUglyNumber(1000000000, 2, 217983653, 336916467)); // 1999999984
    }

    // 寻找第 n 个丑数
    public int nthUglyNumber(int n, int a, int b, int c) {
        int p = 1;
        long productA = a, productB = b, productC = c;
        long min = -666;
        while (p < n) {
            min = Math.min(Math.min(productA, productB), productC);
            p++;
            if (min == productA) {
                productA += a;
            }
            if (min == productB) {
                productB += b;
            }
            if (min == productC) {
                productC += c;
            }
        }
        return (int) min;
    }
}


