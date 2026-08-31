N = int(input())

def dfs(s, mx):
    if (len(s) == N):
        print(s)
        return
    for i in range(mx + 1):
        dfs(s + chr(97 + i), mx + (i == mx))

dfs('', 0)
