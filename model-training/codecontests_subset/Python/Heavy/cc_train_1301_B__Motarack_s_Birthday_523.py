t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    b = []
    for i in range(n):
        if a[i]==-1:
            if i-1>=0 and a[i-1]!=-1:
                b.append(a[i-1])
            if i+1<n and a[i+1]!=-1:
                b.append(a[i+1])
    if b==[]:
        print(0,0)
        continue
    
    x = max(b)
    y = min(b)
    z = (x+y)//2
    diff = 0
    for i in range(n):
        if a[i]==-1:
            a[i] = z
    for i in range(n-1):
        diff = max(diff,abs(a[i]-a[i+1]))
    print(diff,z)