from itertools import combinations

n = int(input())

def dfs(s):
    if len(s) == n:
        print(s)
        return 0
    for i in range(ord('a'), ord(max(s))+2):
        t = s
        t += chr(i)
        dfs(t)


dfs('a')