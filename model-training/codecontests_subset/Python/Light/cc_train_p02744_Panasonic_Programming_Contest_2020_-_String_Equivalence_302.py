n=int(input())
def dfs(s):
    if len(s)==n:print(s)
    else:
        for i in range(97,ord(max(s))+1+1):
            dfs(s+chr(i))
dfs("a")
