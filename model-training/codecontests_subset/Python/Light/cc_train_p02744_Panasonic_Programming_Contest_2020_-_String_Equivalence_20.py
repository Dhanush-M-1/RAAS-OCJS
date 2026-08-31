def f(word,N):
    if len(word)==n:
        return print(word)
    else:
        for i in range(N+1):
            f(word+chr(97+i),N+1 if i==N else N)


n=int(input())
f("",0)