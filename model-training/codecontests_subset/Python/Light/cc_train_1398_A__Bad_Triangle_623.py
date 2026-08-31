t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    i,j,k=0,1,2
    flag=0
    while(i<n and j<n and k<n):
        if(a[i]+a[j]<=a[k]):
            flag=1
            break
        else:
            k+=1
    if(flag==1):
        print(i+1,j+1,k+1)
    else:
        print(-1)
        