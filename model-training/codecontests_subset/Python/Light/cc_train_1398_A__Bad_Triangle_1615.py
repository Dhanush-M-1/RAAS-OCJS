# https://codeforces.com/contest/1398/problem/0
import sys
reader = (s.rstrip() for s in sys.stdin)
input = reader.__next__
# do magic here
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    if arr[0] + arr[1] <= arr[-1]:
        print(1,2,n)
    else:
        print(-1)