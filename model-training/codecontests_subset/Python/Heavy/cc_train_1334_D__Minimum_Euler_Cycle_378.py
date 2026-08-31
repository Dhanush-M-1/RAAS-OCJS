#!/usr/bin/env python3
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, l, r = map(int, input().split())
    num = r - l + 1
    init_num = 1
    index = 0
    for i in range(1, n):
        init_num = i
        if l <= (n - i) * 2:
            index = l
            l = 0
            break
        else:
            l -= (n - i) * 2
    # Last block
    if l > 0:
        print(1)
        continue
    ans = []
    for i in range(1, n):
        if i < init_num:
            continue
        for j in range((n - i) * 2):
            if i == init_num and j < index - 1:
                continue
            elif j % 2 == 0:
                ans.append(i)
                num -= 1
            else:
                ans.append((j+1) // 2 + i)
                num -= 1
            if num == 0:
                break
        if num == 0:
            break
    if num > 0:
        ans.append(1)
    print(*ans)