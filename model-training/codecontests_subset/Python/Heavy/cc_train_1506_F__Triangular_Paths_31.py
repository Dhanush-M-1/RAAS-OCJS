import io
import os

from collections import Counter, defaultdict, deque


def solve(N, R, C):
    for r, c in zip(R, C):
        if r == c == 1:
            break
    else:
        R.append(1)
        C.append(1)
        N += 1
    order = sorted(list(range(N)), key=lambda i: R[i])
    ans = 0
    for i, j in zip(order, order[1:]):
        r1 = R[i]
        c1 = C[i]
        r2 = R[j]
        c2 = C[j]
        d1 = r1 - c1
        d2 = r2 - c2
        cost = 0
        if d1 % 2 == 0 and d1 == d2:
            cost = r2 - r1
        else:
            cost = (d2 // 2) - (d1 // 2)


        ans += cost
    return ans


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    TC = int(input())
    for tc in range(1, TC + 1):
        (N,) = [int(x) for x in input().split()]
        R = [int(x) for x in input().split()]
        C = [int(x) for x in input().split()]
        ans = solve(N, R, C)
        print(ans)
