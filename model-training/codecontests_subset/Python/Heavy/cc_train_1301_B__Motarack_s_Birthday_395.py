import math
for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    mi=min(a)
    ma=max(a)
    maxe=-1
    mine=-1
    if ma==-1:
        print(0, 0)
        continue
    ma=-1000000079404
    mi=6584949003033
    for i in range(len(a)-1):
        if(a[i]!=-1 and a[i+1]==-1):
            if mi>a[i]:
                mi=a[i]
            if ma<a[i]:
                ma=a[i]
        if(a[i+1]!=-1 and a[i]==-1):
            if mi>a[i+1]:
                mi=a[i+1]
            if ma<a[i+1]:
                ma=a[i+1]
        if(a[i+1]!=-1 and a[i]!=-1):
            if maxe < abs(a[i+1]-a[i]):
                maxe=abs(a[i]-a[i+1])
    printch=(mi+ma)//2
    if(maxe!=-1):
        if maxe>=ma-printch:
            print(maxe,printch)
        else:
            print(ma-printch,printch)
    else:
        print(ma-printch, printch)
    
        
        