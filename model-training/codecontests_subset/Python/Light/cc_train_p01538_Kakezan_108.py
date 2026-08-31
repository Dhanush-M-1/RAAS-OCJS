#!/usr/bin/env python3
q = int(input())
for _ in range(q):
    n = input()
    for k in range(len(n)**2):
        if len(n) == 1:
            print(k)
            break
        n = str(max(int(n[:i]) * int(n[i:]) for i in range(1, len(n))))


