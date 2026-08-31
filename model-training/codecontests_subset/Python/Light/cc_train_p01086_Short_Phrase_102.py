def es(k,le):
    i=k
    x=0
    while le>x:
        x+=len(l[i])
        i+=1
    if le==x:return i
    else: return 0



while True:
    n=int(input())
    if n==0:break
    l=[input() for _ in range(n)]
    ans=1
    for i in range(n):
        k=i
        k=es(k,5)
        if k==0:continue
        k=es(k,7)
        if k==0:continue
        k=es(k,5)
        if k==0:continue
        k=es(k,7)
        if k==0:continue
        k=es(k,7)
        if k==0:continue
        print(ans+i)
        break
