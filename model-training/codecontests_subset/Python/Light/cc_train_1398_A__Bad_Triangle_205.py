t=int(input(""))
while t>0:
    n=int(input(""))
    a=list(map(int,input().split()))
    if(a[0]+a[1]<=a[-1]):
        print(1,2,n)
    elif(a[0]<=(a[-1]-a[-2])):
        print(1,n,n-1)
    else:
        print(-1)
        
    t-=1