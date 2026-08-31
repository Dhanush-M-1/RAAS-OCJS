def dfs(s, mx):
    if len(s) == n:
        print(s)
        return
    for i in range(ord('a'), mx + 2):
        dfs(s + chr(i), max(mx, i))


n = int(input())
dfs('', ord('a') - 1)
