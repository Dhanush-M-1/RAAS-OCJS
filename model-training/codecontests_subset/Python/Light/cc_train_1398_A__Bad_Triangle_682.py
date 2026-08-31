import sys
t=int(input())
while t>0:
    n=int(input())
    a=[int(x) for x in input().split()]
    s=a[0]+a[1]
    c=0
    for i in range(2,n):
        if(a[i]>=s):
            print(1,2,i+1)
            c+=1
            break
    if(c==0):
        print(-1)
    t-=1
        
      