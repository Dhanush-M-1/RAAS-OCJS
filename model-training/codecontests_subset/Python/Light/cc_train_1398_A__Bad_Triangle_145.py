t=int(input())
for hh in range(0,t):
    n=int(input())
    a=[int(x) for x in input().split()]
    if (a[0]+a[1])>a[-1]:
        print(-1)
    else:
        print(1,2,n)
    
    
    