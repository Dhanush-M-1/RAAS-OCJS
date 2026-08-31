n = int(input())
l = "abcdefghij"
def dfs(res, i):
    if len(res) >= n:
        print(res)
        return
    for k in range(i):
        dfs(res+l[k], i)
    dfs(res+l[i], i+1)
dfs("", 0)