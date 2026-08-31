# @author 

import sys

class BMultiplyBy2DivideBy6:
    def solve(self, tc=0):
        for _ in range(int(input())):
            n = int(input())
            two = 0
            while n % 2 == 0:
                n //= 2
                two += 1

            three = 0
            while n % 3 == 0:
                n //= 3
                three += 1

            # print(two, three)

            if n != 1 or two > three:
                print(-1)
            else:
                print(2 * three - two)



solver = BMultiplyBy2DivideBy6()
input = sys.stdin.readline

solver.solve()
