N = int(input())

def dfs(s, mx):
    if len(s) == N:
        print(s)
        return
    for c in 'abcdefghij'[:(ord(mx)-ord('a'))+1]:
        dfs(s+c, chr(ord(mx)+1)) if c == mx else dfs(s+c, mx)

dfs('', 'a')