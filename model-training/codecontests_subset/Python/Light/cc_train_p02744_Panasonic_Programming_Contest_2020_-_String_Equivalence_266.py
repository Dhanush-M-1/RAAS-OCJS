def DFS(word,n):
    if len(word)==N:print(word)
    else:
        for i in range(n+1):
            DFS(word+chr(97+i),n+1 if i==n else n)


N=int(input())
DFS("",0)