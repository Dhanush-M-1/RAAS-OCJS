N = int(input())
alp = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j"]

def dfs(s, n):
    if len(s) == N:
        print(s)
        return
    for i in range(n+1):
        dfs(s+alp[i], max(n, i+1))

dfs("", 0)