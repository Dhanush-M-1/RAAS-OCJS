"""
Author: Q.E.D
Time: 2020-08-14 09:36:04
"""
T = int(input())
for _ in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)