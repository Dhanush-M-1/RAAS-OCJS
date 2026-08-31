import string

t = int(input())
for i in range(t):
    n,m = map(int,input().split())
    s = input()
    p = list(map(int,input().split()))
    p.sort()
    j=0
    a=0
    d = dict.fromkeys(string.ascii_lowercase, 0)
    for j in range(m):
        
        if (a==p[j]):
            pass
        else:
            for k in range(a,p[j]):
                d[s[k]] += m+1-j
        a=p[j]
    if (p[m-1]==n):
        pass
    else:
        for k in range(p[m-1],n):
            d[s[k]] += 1

    ans = list(d.values())
    print(*ans)