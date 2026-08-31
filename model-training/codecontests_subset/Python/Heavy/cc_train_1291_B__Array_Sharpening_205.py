for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    if n&1:
        res=True
        m=(n-1)//2
        i=0
        sign=1
        b=[]
        for x in range(n):
            if i==m:
                sign=-1
            b.append(i)
            i+=sign
        for j in range(n):
            if a[j]<b[j]:
                res=False
                break
        print("YNeos"[not res::2])

    else:
        res1=True
        res2=True
        m=n//2
        i=0
        sign=1
        b1=[]
        for x in range(n):
            b1.append(i)
            if i==m:
                i-=1
                sign=-1
            i+=sign
        b2=b1[::-1]

        for j in range(n):
            if a[j]<b1[j]:
                res1=False
                break

        for j in range(n):
            if a[j]<b2[j]:
                res2=False
                break

        res=res1 or res2
        print("YNeos"[not res::2])
