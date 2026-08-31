#!/usr/bin/env python3
def ri():
    return map(int, input().split())

a, b = input().split()
n = int(input())
print(a, b)
for i in range(n):
    c, d = input().split()
    if a == c:
        print(b, d)
        a = d
    else:
        print(a, d)
        b = d

    print