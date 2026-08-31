import io
import os

from collections import Counter, defaultdict, deque



def solve(N, PC):
    if all(p >= c for p, c in PC):
        for (p1, c1), (p2, c2) in zip(PC, PC[1:]):
            deltaP = p2 - p1
            deltaC = c2 - c1
            if deltaP < 0 or deltaC < 0 or deltaC > deltaP:
                return "NO"
        return "YES"
    return "NO"


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    T = int(input())
    for t in range(T):
        (N,) = [int(x) for x in input().split()]
        PC = [[int(x) for x in input().split()] for i in range(N)]
        ans = solve(N, PC)
        print(ans)
