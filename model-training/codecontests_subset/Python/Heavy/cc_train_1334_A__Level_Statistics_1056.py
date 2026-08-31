def funct(c,p):
    for i in range(len(c)-1):
        if c[i]>c[i+1]:
            return('NO')

    for i in range(len(p)-1):
        if p[i]>p[i+1]:
            return('NO')

    for i in range(len(c)):
        if c[i]>p[i]:
            return('NO')

    for i in range(1, len(c)):
        if p[i]-p[i-1]<c[i]-c[i-1]:
            return('NO')
    return('YES')

n = int(input())
for i in range(n):
    m = int(input())
    c = []
    p = []
    for j in range(m):
        s = input().split()
        c.append(int(s[1]))
        p.append(int(s[0]))
    print(funct(c,p))
    
