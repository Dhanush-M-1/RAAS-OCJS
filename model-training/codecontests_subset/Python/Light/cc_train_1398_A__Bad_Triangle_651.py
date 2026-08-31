t=int(input())
while (t>0):
    t=t-1
    n=int(input())
    a=list(map(int,input().split()))
    c=a[0]+a[1]
    d=0
    for i in range(2,len(a)):
        if (c<=a[i]):
            d=i+1
            break
    if (d!=0):
        print(1,2,d)
    else:
        print(-1)