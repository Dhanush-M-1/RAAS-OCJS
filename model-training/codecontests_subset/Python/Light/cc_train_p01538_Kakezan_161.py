#!/usr/bin/env python
# -*- coding: utf-8 -*-

Q = int(input())
N = [input() for i in range(0,Q)]

integer = lambda x: int(x) if x != '' else 0
for n in N:
    ans = '0' if int(n) // 10 == 0 else str(n)
    count = 0
    while int(ans) // 10 > 0:
        count += 1
        tmp = 0
        for i in range(1,len(ans)):
            tmp = max(tmp,integer(ans[:i]) * integer(ans[i:]))
        ans = str(tmp)
    else:
        print(count)