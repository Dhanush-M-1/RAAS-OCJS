N = int(input())

def dfs(s, mx):
    if len(s) == N:
        print(s)
    else:
        for c in range(ord('a'), ord(mx)+1):
            if chr(c) == mx:
                mx = chr(c+1)
            dfs(s+chr(c), mx)

dfs("", 'a')