def f(word,n):
    if len(word)==N:return print(word)
    else:
        for i in range(n+1):
            f(word+chr(97+i),n+1 if i==n else n)


N=int(input())
f("",0)