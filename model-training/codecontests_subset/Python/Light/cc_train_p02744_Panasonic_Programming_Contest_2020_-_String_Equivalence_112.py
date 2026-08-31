N = int(input())
ASC = 97

def dfs(s, mx):
    if len(s) == N:
        print(s)
        return
    for c in range(ASC, mx+2):
        t = s + chr(c)
        dfs(t, max(mx, c))
    
s = 'a'
mx = ord(s)
dfs(s, mx)
