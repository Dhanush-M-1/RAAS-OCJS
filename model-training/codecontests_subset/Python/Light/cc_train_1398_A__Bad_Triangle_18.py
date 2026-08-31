#code
import bisect
for _ in range(int(input())):
    n=int(input())
    a=[int(s) for s in input().split()]
    i=0
    j=0
    f=0
    while(i<n-1):
        s=a[i]+a[i+1]
        j=bisect.bisect_left(a,s)
        if j<n:
            f=1 
            break
        i+=1
    if f:    
        print(i+1,i+2,j+1)
    else:
        print(-1)