n=int(input())

def dfs(s,mx):
    if len(s)==n:
        print(s)
        return
    for c in range(ord('a'),mx+2):
        t=s
        t+=chr(c)
        dfs(t,max(mx,c))

dfs("",ord('a')-1)