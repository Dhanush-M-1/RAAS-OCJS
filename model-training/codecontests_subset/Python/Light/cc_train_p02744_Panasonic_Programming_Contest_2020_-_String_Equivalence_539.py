def DFS(word,N):
    if len(word)==n:print(word)
    else:
        for i in range(N+1):
            DFS(word+chr(97+i),N+1 if i==N else N)


n=int(input())
DFS("",0)