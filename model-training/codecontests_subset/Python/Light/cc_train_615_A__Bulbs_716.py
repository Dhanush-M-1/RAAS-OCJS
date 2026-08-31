#!/bin/python3

import sys
n,m = map(int, input().split())
ans = set()
for i in range(n):
    ans = ans |set(list(map(int, input().split()))[1:])
if len(ans) == m:
    print("YES")
else:
    print("NO")