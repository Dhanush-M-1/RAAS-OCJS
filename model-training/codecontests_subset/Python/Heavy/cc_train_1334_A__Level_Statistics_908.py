T = int(input().strip())

for t in range(T):
    n = int(input().strip())
    p = []
    c = []
    for i in range(n):
        _p, _c = map(int, input().strip().split())
        p.append(_p)
        c.append(_c)
    if any(pi < ci for pi, ci in zip(p,c)):
        print("NO")
    elif any(p[i-1] > p[i] for i in range(1,n)):
        print("NO")
    elif any(c[i-1] > c[i] for i in range(1,n)):
        print("NO")
    elif any(p[i]-p[i-1] < c[i]-c[i-1] for i in range(1,n)):
        print("NO")
    else:
        print("YES")
        

