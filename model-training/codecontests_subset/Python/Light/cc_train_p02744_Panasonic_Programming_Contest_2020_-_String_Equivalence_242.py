N=int(input())

def dfs(s, mx):
    if len(s) == N:
        print(s)
    else:
        for o in range(ord('a'),ord(mx)+1):
            dfs(s + chr(o), chr(ord(mx)+1) if o==ord(mx) else mx)


dfs("",'a')