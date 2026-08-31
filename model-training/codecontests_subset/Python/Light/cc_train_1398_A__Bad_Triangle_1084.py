t=int(input())
## sum of two sides is greater than theird side
## 4 6 9 10 18 
for _ in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    tr=0
    for i in range(0,n-2):
        s=a[i]+a[i+1]
        if s<=a[n-1]:
            b=[i,i+1,n-1]
            tr=1
            break
    if tr==1:
        print(b[0]+1,b[1]+1,b[2]+1)
    else:
        print("-1")
            
