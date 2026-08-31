#!/usr/bin/pypy3
# import sys
# sys.stdin = open("/home/vaibhav/python/input.txt", "r")
# sys.stdout = open("/home/vaibhav/python/output.txt", "w")
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    if (a[0] + a[1]) <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)
