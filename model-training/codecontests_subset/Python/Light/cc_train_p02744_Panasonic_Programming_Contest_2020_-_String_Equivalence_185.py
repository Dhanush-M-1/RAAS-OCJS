n = int(input())

def dfs(s, mx):
    if len(s) == n:
        print(s)
    else:
        for i in range(ord("a"), ord(mx) + 2):
            tmp = s
            tmp += chr(i)
            dfs(tmp, max(mx, chr(i)))

dfs("a", "a")