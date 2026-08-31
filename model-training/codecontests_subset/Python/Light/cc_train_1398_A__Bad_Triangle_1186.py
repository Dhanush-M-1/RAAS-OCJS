t=int(input())
for i in range (t):
    n=int(input())
    a=list(map(int,input().split()))
    flag=0
    for j in range(n-2) :
        if flag==1:
            break
        for k in range (n-1,j+1,-1):
            if a[k] >= a[j]+a[j+1]:
                 print (j+1,j+2,k+1)
                 flag=1
                 break
            if a[k]< a[j]+a[j+1]:
                 break
    if flag ==0:
        print(-1)
    
