t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    nei = []
    default = 0
    for x, y in zip(a, a[1:]):
        if x==-1 and y!=-1:
            nei.append(y)
        if x!=-1 and y==-1:
            nei.append(x)
        if x!=-1 and y!=-1:
            default=max(default, abs(x-y))
   
    if not nei:
        print(0, 1)
        continue
        
    mi = min(nei)
    ma = max(nei)
    
    k = (mi+ma)//2
    m = max(abs(mi-k),abs(ma-k), default)
    
    print(m, k)
