# @author 

import sys

class CBeautifulRegionalContest:
    def solve(self):

        for _ in range(int(input())):
            n = int(input())
            p = [int(_) for _ in input().split()]

            # l, r = 5, n // 2
            #
            # while l <= r:
            #     m = (l + r) >> 1
            #     if check(p, m):
            #         l = m
            #     else:
            #         r = m - 1

            cnt = {x : 0 for x in p}
            for x in p:
                cnt[x] += 1

            cnts = list(cnt.items())
            cnts.sort(reverse=True)
            s = 0
            i = 0
            # print(cnts)
            while i < n and s + cnts[i][1] <= n // 2:
                s += cnts[i][1]
                i += 1
            k = i
            # print(cnts[:k])
            g = cnts[0][1]
            s = 0
            b = 0
            i = 1
            while i < k and s <= g:
                s += cnts[i][1]
                i += 1

            b = sum(cnts[i][1] for i in range(k)) - s - g

            if g < s and g < b and g > 0 and s > 0 and b > 0:
                print(g, s, b)
            else:
                print(0, 0, 0)


solver = CBeautifulRegionalContest()
input = sys.stdin.readline

solver.solve()
