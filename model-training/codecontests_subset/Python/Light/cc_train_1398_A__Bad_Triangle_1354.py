t=int(input())
while t>0:
    n=int(input())
    a=[int(x) for x in input().split()]
    flag=0
    if a[0]+a[1]<=a[n-1]:
        flag=1
        print(1,2,n)
    if flag==0:
        print("-1")
    t-=1