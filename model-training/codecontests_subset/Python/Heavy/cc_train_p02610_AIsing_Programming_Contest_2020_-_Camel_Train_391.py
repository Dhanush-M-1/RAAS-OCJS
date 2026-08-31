#!python3

import sys
iim = lambda: map(int, sys.stdin.readline().rstrip().split())
from heapq import heappush, heappushpop

def resolve():
    it = map(int, sys.stdin.read().split())

    T = next(it)
    ans = []
    for i in range(T):
        N = next(it)

        val = 0; a1 = []; a2 = []
        for i, v1, v2 in ((next(it), next(it), next(it)) for i in range(N)):
            diff = v1 - v2
            if diff == 0:
                val += v1
            elif diff > 0:
                a1.append((i, diff))
                val += v2
            else:
                a2.append((N-i, -diff))
                val += v1
        a1.sort(); a2.sort()

        for aa in (a1, a2):
            dq = []
            for i, diff in aa:
                ld = len(dq)
                if ld < i:
                    heappush(dq, diff)
                else:
                    diff = heappushpop(dq, diff)

            val += sum(dq)

        ans.append(val)


    print(*ans, sep="\n")



if __name__ == "__main__":
    resolve()
