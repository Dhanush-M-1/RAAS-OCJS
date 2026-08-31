def dfs(s,x):
    if len(s) == n:
        print(s)
    else:
        for c in range(ord('a'),ord(x) + 1):
            dfs(s + chr(c),chr(ord(x) + 1) if chr(c) == x  else x)

n = int(input())
dfs("",'a')