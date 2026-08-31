n=int(input())
o=ord('a')

def dfs(s,m):
    if len(s)==n:
        print(s)
    else:
        for i in range(m+1):
            dfs(s+chr(o+i),max(m,i+1))
dfs("",0)