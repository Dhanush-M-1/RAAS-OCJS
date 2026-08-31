# @author 

import sys

class BArraySharpening:
    def solve(self):

        def decide(arr):
            cur = -1
            stop = n
            for i in range(n):
                if arr[i] <= cur:
                    stop = i
                    break
                else:
                    cur += 1
            cur = -1
            if stop == n:
                return True
            for i in range(n - 1, stop - 2, -1):
                if arr[i] <= cur:
                    return False
                cur += 1

            return True

        for _ in range(int(input())):
            n = int(input())
            a = [int(_) for _ in input().split()]
            print("Yes" if decide(a) else "No")

solver = BArraySharpening()
input = sys.stdin.readline

solver.solve()
