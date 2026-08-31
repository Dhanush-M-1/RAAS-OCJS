t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    m = n-1 
    l = 1
    if a[m]>=a[l-1]+a[l]:
            print(l,l+1,m+1)
            
    else:
        print(-1)
    