n = int(input())
def dfs(s):
    if len(s) == n:
        print(s)
        return
    for i in range(ord("a"), ord(max(s))+2):
        dfs(s+chr(i))
dfs("a")