t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    b = []
    c = []
    for i in range(n):
        if a[i] == -1:
            if i != 0:
                if a[i-1] != -1:
                    b.append(a[i-1])
            if i != n-1:
                if a[i+1] != -1:
                    b.append(a[i+1])
    for i in range(n-1):
        if a[i] != -1 and a[i+1] != -1:
            c.append(abs(a[i+1]-a[i]))
    #b.sort()
    #print(b)
    if c == []:
        c.append(0)
    if b == []:
        print(0,0)
        continue
    k = (max(b) + min(b)) // 2
    m = max(max(b)-k,k-min(b),max(c))
    print(m,k)