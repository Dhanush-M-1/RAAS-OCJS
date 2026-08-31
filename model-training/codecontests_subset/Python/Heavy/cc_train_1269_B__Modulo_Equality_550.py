# @author 

import sys


class BModuloEquality:
    def solve(self):
        from collections import defaultdict
        n, m = [int(_) for _ in input().split()]
        a = [int(_) for _ in input().split()]
        b = [int(_) for _ in input().split()]
        cnt_b = defaultdict(int)
        for x in b:
            cnt_b[x] += 1

        cnt_a = defaultdict(int)
        for x in a:
            cnt_a[x] += 1

        b_list = [[cnt_b[x], x] for x in cnt_b]
        # b_list.sort()

        a_list = [[cnt_a[x], x] for x in cnt_a]
        # a_list.sort()

        # print(a_list)
        # print(b_list)
        cands = []
        for i in range(len(b_list)):
            if b_list[i][0] == a_list[0][0]:
                cands.append((b_list[i][1] - a_list[0][1]) % m)
        # print(cands)

        cands.sort()
        for x in cands:
            if sorted([(i + x) % m for i in a]) == sorted(b):
                print(x)
                return


solver = BModuloEquality()
input = sys.stdin.readline

solver.solve()
