import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    
    if a==[-1]*n:
        print(0, 1)
        continue
    
    l = []
    
    for i in range(n):
        if a[i]==-1:
            continue
        
        if i==0:
            if a[i+1]==-1:
                l.append(a[i])
        elif i==n-1:
            if a[i-1]==-1:
                l.append(a[i])
        else:
            if a[i-1]==-1 or a[i+1]==-1:
                l.append(a[i])
    
    l.sort()
    k = (l[0]+l[-1])//2
    m = -1
    
    for i in range(n):
        if a[i]==-1:
            a[i] = k
    
    for i in range(n-1):
        m = max(m, abs(a[i]-a[i+1]))
    
    print(m, k)