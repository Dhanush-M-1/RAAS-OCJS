import sys
 
stdin = sys.stdin
 
ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))
ns = lambda: stdin.readline().rstrip()  # ignore trailing spaces

t = ni()
for _ in range(t):
    n = ni()
    ar = [int(x) for x in input().split()]
    if (ar[0] + ar[1] <= ar[-1]):
        print("1 2 "+str(n))
    else:
        print("-1")

