#TODO
def dfs(word, idx):
    if len(word)==n:
        print(word)
        return
    for j in range(idx):
        dfs(word+chr(j+mx), idx)
    dfs(word+chr(idx+mx), idx+1)

n = int(input())
mx = ord('a')
dfs("", 0)