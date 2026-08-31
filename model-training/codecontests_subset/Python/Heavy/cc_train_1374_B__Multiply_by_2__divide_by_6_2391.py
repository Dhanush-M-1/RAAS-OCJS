import math


class Solution:
    def solve(self, n):
        # factorization
        cnt_2 = 0
        cnt_3 = 0

        while n > 1:
            if n % 2 == 0:
                n = n // 2
                cnt_2 += 1
                continue

            if n % 3 == 0:
                n = n // 3
                cnt_3 += 1
                continue
            return -1

        if cnt_2 > cnt_3:
            return -1
        return (cnt_3 - cnt_2) * 2 + cnt_2


for _ in range(int(input())):
    n = int(input())
    ans = Solution().solve(n)
    print(ans)
