N = int(input())

a_num = 97

def dfs(s): #s: 現在の文字列, n: 残りの文字数, cnt: 現在の文字列の最大の値
    if len(s) == N:
        print(s)
        return
    for i in range(ord("a"), ord(max(s))+2):
        dfs(s+chr(i))

dfs("a")
