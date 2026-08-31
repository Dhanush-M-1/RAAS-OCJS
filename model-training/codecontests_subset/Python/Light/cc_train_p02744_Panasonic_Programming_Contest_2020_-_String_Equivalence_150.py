N = int(input())
str = "abcdefghijklmnopqrstuvwxyz"
def dfs(s,mx):
    if len(s) == N:
        print(s)
    else:
        for c in str[:mx+1]:
            if c == str[mx]: dfs(s+c, mx+1)
            else: dfs(s+c, mx)
dfs("", 0)