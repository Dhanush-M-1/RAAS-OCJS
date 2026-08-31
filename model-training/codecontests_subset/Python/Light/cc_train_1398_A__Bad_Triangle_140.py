try:
    t=int(input())
    for i in range(t):
        n=int(input())
        l=list(map(int,input().split()))
        a=l[0]
        b=l[1]
        v=2
        for i in range(2,n):
            if(l[i]>=(a+b)):
                c=i+1
                break
            else:
                v+=1
        if(v==n):
            print(-1)
        else:
            print(1,2,c)
except:
    pass
