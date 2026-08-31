for s in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    add=a[0]+a[1]
    flag=0
    for i in range(2,n):
        if(a[i]>=add):
            flag=-1
            break
    if(flag==0):
        print(-1)
    else:
        print(1,2,i+1)