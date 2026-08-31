import sys
sys.setrecursionlimit(1000000)


def dfs(s):
    if len(s) == n:
        print(s)
        return
    kind = len(set(s))
    for i in range(kind + 1):
        dfs(s + chr(ord('a') + i))


n = int(input())
dfs('')
