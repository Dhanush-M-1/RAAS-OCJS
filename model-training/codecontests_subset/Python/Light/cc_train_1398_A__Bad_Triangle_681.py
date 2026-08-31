from collections import defaultdict
t=int(input())
while(t>0):
    t-=1
    n=int(input())
    a=[int(j) for j in input().split()]
    if(a[0]+a[1]<=a[-1]):
        print("1 2",end=" ")
        print(len(a))
    else:
        print(-1)
    
