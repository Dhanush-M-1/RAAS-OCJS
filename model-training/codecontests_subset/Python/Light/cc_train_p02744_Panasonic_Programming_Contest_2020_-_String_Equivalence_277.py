n = int(input())
def dfs(s,c):
    if len(s)==n:
        print(s)
        return
    for i in range(ord("a"),ord(c)+2):
        if i>ord(c):
            dfs(s+chr(i),chr(i))
        else:
            dfs(s+chr(i),c)

dfs("a","a")