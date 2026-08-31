N = int(input())

# mx = count up flag
def dfs(s, mx):
    if len(s) == N:
        print(s)
    else:
        for c in range(ord('a'), mx+1):
            dfs(s+chr(c), mx + 1 if c == mx else mx)

dfs("", ord('a'))
