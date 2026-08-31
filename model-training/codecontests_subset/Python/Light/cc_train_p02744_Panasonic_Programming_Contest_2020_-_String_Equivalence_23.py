N = int(input())

a_num = 97

def dfs(s, n): #s: 現在の文字列, n: 残りの文字数, cnt: 現在の文字列の最大の値
    if n == 0:
        print(s)
        return
    for i in range(ord("a"), ord(max(s))+2):
        dfs(s+chr(i), n-1)

dfs("a", N-1)
