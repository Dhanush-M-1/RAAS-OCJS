#解説AC

n = int(input())

def dfs(s, mx):
    if len(s) == n:
        print(s)
    else:
        for i in range(ord('a'), ord(mx)+1):

            dfs(s + chr(i), chr(ord(mx) + 1) if i == ord(mx) else mx)
dfs('', 'a')