import math
for _ in range(int(input())):
    n=int(input())
    li=list(map(int,input().split()))
    d=999999988888
    e=-1
    z=0
    if n==1:
        print(0,1)
    else:
        for i in range(n-1):
            if li[i]==-1:
                if li[i+1]!=-1:
                    d=min(d,li[i+1])
                    e=max(e,li[i+1])
            else:
                if li[i+1]!=-1:
                    z=max(abs(li[i+1]-li[i]),z)
        for i in range(n-1,0,-1):
            if li[i]==-1:
                if li[i-1]!=-1:
                    d=min(d,li[i-1])
                    e=max(e,li[i-1])
            else:
                if li[i-1]!=-1:
                    z=max(abs(li[i-1]-li[i]),z)
        if d==999999988888:
            d=12
        print(max((e-d+1)//2,z),(d+e)//2)

        