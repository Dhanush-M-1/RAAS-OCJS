def dfs(s, mx):
    if len(s) == n:
        print(s)
        return
    for c in a[:mx]:
        dfs(s+c, mx)
    dfs(s+a[mx], mx+1)

n = int(input())
a = "abcdefghij"
dfs("", 0)