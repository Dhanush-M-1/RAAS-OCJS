n = int(input())
def dfs(s, i):
    if i == n:
        print(s)
    else:
        for j in range(ord("a"), max(map(ord, list(s))) + 2):
            dfs(s + chr(j), i + 1)
dfs("a", 1)