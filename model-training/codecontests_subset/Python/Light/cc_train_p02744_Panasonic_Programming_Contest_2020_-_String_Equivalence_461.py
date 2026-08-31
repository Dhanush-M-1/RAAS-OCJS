def dfs(s, mx) :
    if len(s) == n :
        print(s)
        return
    else:
        for i in range(ord('a'), mx+2) :
            t = s + chr(i)
            dfs(t, max(mx, i))

n = int(input())
dfs('a', ord('a'))