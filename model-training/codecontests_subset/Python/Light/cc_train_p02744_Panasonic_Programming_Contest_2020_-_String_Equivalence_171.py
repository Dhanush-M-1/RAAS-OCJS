n = int(input())
def dfs(i,s):
    if i == n:
        print(s)
        return
    ma = 0
    for j in s:
        ma = max(ma,ord(j))
    for j in range(ma - 95):
        dfs(i+1,s+chr(97+j))
    return
dfs(1,"a")