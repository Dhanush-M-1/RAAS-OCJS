import copy
import math

r = int(input())

for l in range(r):
    n = int(input())
    arr = [int(d) for d in input().split()]
    if arr[0] + arr[1] <= arr[n-1]:
        print(1, 2, n)
    else:
        print(-1)
