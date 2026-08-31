t = int(input())

for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    mi = float('INF')
    ma = -float('INF')
    value = 0
    for i in range(n):
        if i>0 and a[i] == -1 and a[i-1] != -1:
            mi = min(a[i-1],mi)
            ma = max(ma,a[i-1])
        if i<n-1 and a[i] == -1 and a[i+1] != -1:
            mi = min(a[i+1],mi)
            ma = max(ma,a[i+1])
    value = (mi+ma)//2
    if a.count(-1) == len(a):
        value = 0
    
    m = 0
 
    for i,item in enumerate(a):
        if a[i] == -1:
            a[i] = value
        if(i):
            m = max(m, abs(a[i]-a[i-1]))
    print(m,value)
