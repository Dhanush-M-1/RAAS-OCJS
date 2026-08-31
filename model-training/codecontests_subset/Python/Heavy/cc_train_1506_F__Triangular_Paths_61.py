from bisect import bisect_left, bisect_right
from collections import defaultdict
import sys


def input():
    return sys.stdin.readline().rstrip()


alphabet = [chr(ord("a") + i) for i in range(26)]


def slv():
    n = int(input())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    A = [(u,v) for u,v in zip(a,b)]  + [(1,1)]
    A.sort(key = lambda x: x[0])
    ans = 0
    for i in range(n):
        px,py = A[i]
        qx,qy = A[i + 1]
        qx -= px
        qy -= py
        X,Y = qx - qy,qy
        if (px + py) % 2 != 0:
            ans += (X + 1) // 2
        else:
            if X == 0:
                ans += Y
            else:
                ans += X // 2
    print(ans)
    return


def main():
    t = int(input())
    for i in range(t):
        slv()
    return


if __name__ == "__main__":
    main()
