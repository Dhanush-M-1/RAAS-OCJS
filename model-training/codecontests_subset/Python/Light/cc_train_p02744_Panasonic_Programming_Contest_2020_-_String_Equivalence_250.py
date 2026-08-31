# -*- coding: utf-8 -*-

def dfs(s, mx, N):
    if len(s) == N:
        print(s)
    else:
        for i in range(97, ord(mx) + 1):
            dfs(s + chr(i), chr(max(i + 1, ord(mx))), N)

N = int(input())

dfs('', 'a', N)